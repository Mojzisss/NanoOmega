
import games.*;

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
                x = 250 + i * 300;
            } else {
                y = 700;
                x = 250 + (i - 5) * 300;
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

                    case 3:
                        new Battle(frame);
                        break;

                    case 4:
                        new Memory(frame);
                        break;

//                    case 5:
//                        new (frame);
//                        break;
//
//                    case 6:
//                        new (frame);
//                        break;
//
//                    case 7:
//                        new (frame);
//                        break;
//
//                    case 8:
//                        new (frame);
//                        break;
//
//                    case 9:
//                        new (frame);
//                        break;

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
        buttons[3].setText("Battle");
        buttons[4].setText("Memory");
//        buttons[5].setText("");
//        buttons[6].setText("");
//        buttons[7].setText("");
//        buttons[8].setText("");
//        buttons[9].setText("");
        frame.repaint();
    }


    private void hideButtons() {
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setVisible(false);
        }
    }
}