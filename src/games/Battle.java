package games;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class Battle {

    private JFrame frame;
    private Random rd = new Random();
    private int demageDealed;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private final int MIN_SIZE = 50;
    private long startTime;
    private String playerName;


    public Battle(JFrame frame, String playerName) {

        this.frame = frame;
        this.playerName = playerName;
        if (playerName == null || playerName.isBlank()) {
            this.playerName = "Unknown";
        } else {
            this.playerName = playerName;
        }
        FirstEnemy();
    }


    public class Enemy {

        JButton button;
        int hp;
        int size;
        int targetX;
        int targetY;


        public Enemy(JButton button, int size) {
            this.button = button;
            this.size = size;
            this.hp = Math.max(1, size / 20);
            Timer timer = new Timer(16, e -> update());
            timer.start();
            Run();
        }

        public void updateText() {

            button.setText(String.valueOf(hp));
        }

        private void update() {

            int x = button.getX();
            int y = button.getY();

            int newX = x + (int)((targetX - x) * 0.15);
            int newY = y + (int)((targetY - y) * 0.15);


            if (!wouldCollide(newX, newY)) {
                button.setLocation(newX, newY);
            } else {
                button.setLocation(x, y);
            }
        }

        private boolean wouldCollide(int x, int y) {

            Rectangle me = new Rectangle(x, y, size, size);

            for (Enemy e : enemies) {

                if (e == this) continue;

                Rectangle other = new Rectangle(e.button.getX(), e.button.getY(), e.size, e.size);

                if (me.intersects(other)) {
                    return true;
                }
            }

            return false;
        }

        private void Run() {

            frame.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

                Random r = new Random();

                @Override
                public void mouseMoved(java.awt.event.MouseEvent e) {

                    for (Enemy enemy : enemies) {

                        Point mouse = e.getPoint();

                        int bx = enemy.button.getX() + enemy.button.getWidth() / 2;
                        int by = enemy.button.getY() + enemy.button.getHeight() / 2;

                        int dx = mouse.x - bx;
                        int dy = mouse.y - by;

                        double dist = Math.sqrt(dx * dx + dy * dy);

                        if (dist < 120) {

                            int moveX = enemy.button.getX() - dx;
                            int moveY = enemy.button.getY() - dy;

                            moveX += r.nextInt(40) - 20;
                            moveY += r.nextInt(40) - 20;

                            int maxX = frame.getWidth() - enemy.button.getWidth();
                            int maxY = frame.getHeight() - enemy.button.getHeight();

                            moveX = Math.max(0, Math.min(maxX, moveX));
                            moveY = Math.max(0, Math.min(maxY, moveY));

                            enemy.targetX = moveX;
                            enemy.targetY = moveY;
                        }
                    }
                }
            });
        }
    }


    private void FirstEnemy() {
        startTime = System.currentTimeMillis();
        createEnemy(frame.getWidth() / 2 - 200,frame.getHeight() / 2 - 200,400);
    }

    private void createEnemy(int x, int y, int size) {

        JButton btn = new JButton();
        Enemy enemy = new Enemy(btn, size);
        enemy.button.setBounds(x, y, size, size);
        enemy.updateText();
        enemy.targetX = x;
        enemy.targetY = y;
        enemy.button.addActionListener(e -> {

            enemy.hp--;
            demageDealed ++;
            if (enemy.hp <= 0) {
                split(enemy);
            } else {
                enemy.updateText();
            }
        });

        enemies.add(enemy);
        frame.add(enemy.button);

        frame.revalidate();
        frame.repaint();
    }

    private void split(Enemy enemy) {

        frame.remove(enemy.button);
        enemies.remove(enemy);
        frame.repaint();

        int size = enemy.size;
        if (size <= MIN_SIZE) {
            checkWin();
            return;
        }

        int children = rd.nextInt(2, 6);

        for (int i = 0; i < children; i++) {

            double factor = rd.nextDouble(0.3, 0.6);

            int newSize = (int)(size * factor);
            if(newSize < MIN_SIZE){
                continue;
            }

            int maxX = frame.getWidth() - newSize - 50;
            int maxY = frame.getHeight() - newSize - 50;

            int x;
            int y;
            int attempts = 0;

            do {
                x = rd.nextInt(maxX) + 25;
                y = rd.nextInt(maxY) + 25;
                attempts++;
            } while (collides(x, y, size, null) && attempts < 50);

            createEnemy(x, y, newSize);
        }

        checkWin();

        frame.revalidate();
        frame.repaint();
    }

    private boolean collides(int x, int y, int size, Enemy self) {

        for (Enemy e : enemies) {

            if (e == self) continue;

            Rectangle r1 = new Rectangle(x, y, size, size);
            Rectangle r2 = new Rectangle(e.button.getX(), e.button.getY(), e.size, e.size);

            if (r1.intersects(r2)) {
                return true;
            }
        }

        return false;
    }



    private void checkWin() {

        if (enemies.isEmpty()) {

            long duration = System.currentTimeMillis() - startTime;

            double seconds = duration / 1000.0;

            Leaderboard.saveScore("Battle", playerName, seconds);
            JOptionPane.showMessageDialog(
                    frame,
                    "you won! \nin: "
                            + String.format("%.2f", seconds) + " s"+
                            "\n demage dealed: "+ demageDealed
            );
        }
    }
}