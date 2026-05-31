package games;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Memory {

    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private JButton restartButton = new JButton("Restart");

    private int nextNumber = 1;
    private long startTime;


    public Memory(JFrame frame) {

        this.frame = frame;
        startTime = System.currentTimeMillis();

        createGame();

    }

    private void createGame() {

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);


        restartButton.setBounds(835, 150, 150, 50);
        restartButton.setVisible(false);
        frame.add(restartButton);

        restartButton.addActionListener(e -> {

            frame.getContentPane().removeAll();
            new Memory(frame);
        });


        int index = 0;

        for(int row = 0; row < 3; row++) {

            for(int col = 0; col < 3; col++) {

                JButton button = new JButton(String.valueOf(numbers.get(index)));
                button.setFont(new Font("Arial", Font.BOLD, 60));
                button.setBounds(
                        700 + col * 150,
                        350 + row * 150,
                        120,
                        120

                );

                button.setEnabled(false);

                int value = numbers.get(index);

                button.addActionListener(e -> {

                    if(value == nextNumber) {
                        button.setVisible(false);

                        nextNumber++;
                        if(nextNumber == 10) {
                            long duration = System.currentTimeMillis() - startTime;
                            double seconds = duration / 1000.0;

                            JOptionPane.showMessageDialog(
                                    frame,
                                    "You Win! \nin: "
                                            + String.format("%.2f", seconds) + " s"
                            );
                            restartButton.setVisible(true);
                        }

                    } else {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Game Over"

                        );
                        restartButton.setVisible(true);
                    }

                });

                buttons[index] = button;
                frame.add(button);
                index++;
            }
        }

        frame.revalidate();
        frame.repaint();

        Timer timer =
                new Timer(3000, e -> {
                    for(JButton button : buttons) {
                        button.setText("?");
                        button.setEnabled(true);
                    }
                });

        timer.setRepeats(false);
        timer.start();
    }
}