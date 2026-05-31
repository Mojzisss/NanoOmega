package games;
import javax.swing.*;
import java.util.Random;

public class FindButtongame {

    private JFrame frame;
    private JButton button;

    private Random rd = new Random();

    private int clicked = 0;
    private int buttonSize = 1000;

    public FindButtongame(JFrame frame) {

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

            button.setSize(buttonSize, buttonSize);

            button.setLocation(x, y);

            System.out.println("Clicks: "+ clicked);
        });

        frame.add(button);

        frame.repaint();
    }
}