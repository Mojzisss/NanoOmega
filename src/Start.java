
import games.ButtonSplit;
import games.CleanTheScreen;
import games.FindButton;

import javax.swing.*;
import java.awt.*;

public class Start {

    private JFrame frame;
    private JButton[] buttons;

    public Start() {

        createWindow();
        createButtons();
        frame.setVisible(true);
    }

    private void createWindow() {

        frame = new JFrame("My Project");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createButtons() {

        buttons = new JButton[10];
        JButton exit = new JButton("exit");
        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton();

            int x;
            int y;

            if (i < 5) {
                y = 300;
                x = 300 + i * 300;
            } else {
                y = 700;
                x = 300 + (i - 5) * 300;
            }

            buttons[i].setBounds(x, y, 200, 50);
            exit.setBounds(1700,30,120,40);
            int index = i;

            buttons[i].addActionListener(e -> {

                hideButtons();
                exit.setVisible(true);
                frame.add(exit);
                switch (index) {
                    case 0:
                        new FindButton(frame);
                        break;

                    case 1:
                        new CleanTheScreen(frame);
                        break;

                    case 2:
                        new ButtonSplit(frame);
                        break;
                }
            });
            exit.addActionListener(e -> {

                for (Component c : frame.getContentPane().getComponents()) {
                    if (c instanceof JButton) {
                        c.setVisible(false);
                    }
                }

                for (int j = 0; j < buttons.length; j++) {
                    buttons[j].setVisible(true);
                }

            });


            frame.add(buttons[i]);
        }
        buttons[0].setText("find Button");
        buttons[1].setText("clean screen");
        buttons[2].setText("Button Split");
        frame.repaint();
    }


    private void hideButtons() {
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setVisible(false);
        }
    }
}