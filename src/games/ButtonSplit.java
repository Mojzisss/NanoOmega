package games;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class ButtonSplit {

    private JFrame frame;
    private Random rd = new Random();

    private ArrayList<JButton> buttons = new ArrayList<>();
    private final int MIN_SIZE = 60;


    public ButtonSplit(JFrame frame) {
        this.frame = frame;
        createGame();
    }

    private void createGame() {

        JButton startButton = new JButton();

        int size = 400;

        int x = (frame.getWidth() - size) / 2;
        int y = (frame.getHeight() - size) / 2;

        startButton.setBounds(x, y, size, size);
        buttons.add(startButton);

        startButton.addActionListener(e -> {
                splitButton(startButton);
        });

        frame.add(startButton);
        frame.repaint();
    }

    private void splitButton(JButton button) {

        int oldSize = button.getWidth();

        buttons.remove(button);
        frame.remove(button);
        frame.repaint();

        if (oldSize <= MIN_SIZE) {
            checkWin();

            frame.revalidate();
            frame.repaint();

            return;
        }

        int count = rd.nextInt(2,5);

        for (int i = 0; i < count; i++) {

            double factor = rd.nextDouble(0.6, 0.7);
            int newSize = (int) (oldSize * factor);

            JButton newButton = new JButton();

            int maxWidth = frame.getWidth() - newSize - 20;
            int maxHeight = frame.getHeight() - newSize - 20;

            int x = rd.nextInt(maxWidth) + 10;
            int y = rd.nextInt(maxHeight) + 10;

            newButton.setBounds(x,y,newSize,newSize);
            buttons.add(newButton);

            newButton.addActionListener(e ->
                    splitButton(newButton));

            frame.add(newButton);
        }

        frame.revalidate();
        frame.repaint();

        checkWin();
    }

    private void checkWin() {

        if (buttons.isEmpty()) {
            JOptionPane.showMessageDialog(
                    frame,
                    "you won!"
            );
        }
    }
}