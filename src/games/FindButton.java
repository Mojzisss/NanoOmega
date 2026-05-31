package games;
import javax.swing.*;
import java.util.Random;

public class FindButton {

    private JFrame frame;
    private JButton button;

    private Random rd = new Random();

    private int clicked = 0;
    private int buttonSize = 1000;
    private long startTime;

    public FindButton(JFrame frame) {
        startTime = System.currentTimeMillis();
        this.frame = frame;
        createGame();
    }

    private void createGame() {

        button = new JButton();
        button.setBounds(500, 100, buttonSize, buttonSize);
        button.addActionListener(e -> {

            clicked++;

            double random = rd.nextDouble(0.7, 0.9);

            buttonSize = (int) (buttonSize * random);

            int maxWidth = frame.getWidth() - buttonSize - 50;
            int maxHeight = frame.getHeight() - buttonSize - 50;

            int x = rd.nextInt(maxWidth) + 25;
            int y = rd.nextInt(maxHeight) + 25;

            button.setBounds(x,y,buttonSize,buttonSize);
            checkWin();
        });

        frame.add(button);
        frame.repaint();
    }

    private void checkWin() {

        if (buttonSize<= 1) {

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