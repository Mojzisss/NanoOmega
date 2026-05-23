import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Start start = new Start();
        JFrame windowMain = new JFrame("mainWindow");
        windowMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        windowMain.setLayout(null);
        windowMain.setVisible(true);
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random rd = new Random();
        JButton button = new JButton("button");
        final int[] buttonsize = {windowMain.getHeight() - 100};
        button.setSize(buttonsize[0], buttonsize[0]);
        button.setLocation(200, 200);
        windowMain.add(button);
        final int[] clicked = {0};

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked[0]++;
                double random = rd.nextDouble(0.3, 0.8);
                buttonsize[0] = (int) (buttonsize[0] * random);
                int MaxWidth = windowMain.getWidth() - button.getWidth();
                int MaxHeight = windowMain.getHeight() - button.getHeight();

                int x = rd.nextInt(MaxWidth);
                int y = rd.nextInt(MaxHeight);

                button.setLocation(x, y);
                button.setSize(buttonsize[0], buttonsize[0]);
                System.out.println(clicked[0]);
            }
        });

    }
}