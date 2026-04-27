import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        JFrame windowMain = new JFrame("mainWindow");
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowMain.setSize(1500, 900);
        windowMain.setLocationRelativeTo(null);
        windowMain.setResizable(false);
        windowMain.setVisible(true);


        Random rd = new Random();
        int heightRd = rd.nextInt(100,800);
        int widthRd = rd.nextInt(100,1400);
        JButton button = new JButton("button");
        windowMain.add(button);
        windowMain.revalidate();
        button.setSize(100,100);
        button.setLocation(0,100);

    }
}