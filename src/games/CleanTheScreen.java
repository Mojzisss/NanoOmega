package games;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CleanTheScreen {
    private JFrame frame;
    private JButton[] buttons;
    private Random rd = new Random();

    private int defeated = 0;
    private int buttonSize;
    private int buttonCount;
    private long startTime;




    public CleanTheScreen(JFrame frame) {
        this.frame = frame;
        createGame();
    }

    private void createGame() {
        startTime = System.currentTimeMillis();
        buttonCount = rd.nextInt(50, 100);
        buttons = new JButton[buttonCount];

        for (int i = 0; i < buttons.length; i++) {
            Color randomColor = new Color(
                    rd.nextInt(256),
                    rd.nextInt(256),
                    rd.nextInt(256)
            );
            buttons[i] = new JButton();
            buttonSize = rd.nextInt(50, 400);

            int maxWidth = frame.getWidth() - buttonSize - 50;
            int maxHeight = frame.getHeight() - buttonSize - 50;

            int x = rd.nextInt(maxWidth) + 25;
            int y = rd.nextInt(maxHeight) + 25;

            buttons[i].setBounds(x, y, buttonSize, buttonSize);
            buttons[i].setBackground(randomColor);
            frame.add(buttons[i]);


            int finalI = i;
            buttons[i].addActionListener(e -> {
                buttons[finalI].setVisible(false);
                defeated++;
                checkWin();
            });

        }
        frame.repaint();
    }

    private void checkWin() {

        if (defeated == buttonCount ) {

            long duration = System.currentTimeMillis() - startTime;

            double seconds = duration / 1000.0;

            JOptionPane.showMessageDialog(
                    frame,
                    "You Win! \nin: "
                            + String.format("%.2f", seconds) + " s"
            );
        }
    }
}
