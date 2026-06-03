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

    public Battle(JFrame frame) {

        this.frame = frame;
        FirstEnemy();
    }


    public class Enemy {

        JButton button;
        int hp;
        int size;

        public Enemy(JButton button, int size) {
            this.button = button;
            this.size = size;
            this.hp = Math.max(1, size / 20);
        }

        public void updateText() {
            button.setText(String.valueOf(hp));
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

            int x = rd.nextInt(maxX) + 25;
            int y = rd.nextInt(maxY) + 25;

            createEnemy(x, y, newSize);
        }

        checkWin();

        frame.revalidate();
        frame.repaint();
    }

    private void checkWin() {

        if (enemies.isEmpty()) {

            long duration = System.currentTimeMillis() - startTime;

            double seconds = duration / 1000.0;

            JOptionPane.showMessageDialog(
                    frame,
                    "you won! \nin: "
                            + String.format("%.2f", seconds) + " s"+
                            "\n demage dealed: "+ demageDealed
            );
        }
    }
}