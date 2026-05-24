import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        JFrame windowMain = new JFrame("mainWindow");
        windowMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        windowMain.setLayout(null);
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("🦆");
        button.setBounds(300, 300, 500, 500);

        Random rd = new Random();

        windowMain.add(button);

        windowMain.setVisible(true);

        button.addActionListener(
                new FindButtongame(button, windowMain, rd)
        );
    }
}
