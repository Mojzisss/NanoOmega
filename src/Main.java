import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        JFrame windowMain = new JFrame("mainWindow");
        windowMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        windowMain.setLayout(null);
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("🥔");
        windowMain.setVisible(true);
        button.setSize( windowMain.getHeight()-100, windowMain.getHeight()-100);
        button.setLocation((windowMain.getWidth()-windowMain.getHeight()+100)/2,50);
        windowMain.add(button);

        Random rd = new Random();



        button.addActionListener(
                new FindButtongame(button, windowMain, rd, windowMain.getHeight())
        );
    }
}
