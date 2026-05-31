package games;
import javax.swing.*;
import java.util.Random;

public class CleanTheScreen {
    private JFrame frame;
    private JButton[] buttons;
    private Random rd = new Random();

    private int defeated = 0;
    private int buttonSize;
    private int buttonCount;

    public CleanTheScreen(JFrame frame) {
        this.frame = frame;
        createGame();
    }

    private void createGame() {
        buttonCount = rd.nextInt(3,100);
        buttons = new JButton[buttonCount];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonSize = rd.nextInt(20,1000);

            int maxWidth = frame.getWidth() - buttonSize - 50;
            int maxHeight = frame.getHeight() - buttonSize - 50;

            int x = rd.nextInt(maxWidth) + 25;
            int y = rd.nextInt(maxHeight) + 25;

            buttons[i].setBounds(x,y,buttonSize,buttonSize);
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

        if (defeated == buttonCount+1) {
            JOptionPane.showMessageDialog(
                    frame,
                    "you won!"
            );
        }
    }
}
