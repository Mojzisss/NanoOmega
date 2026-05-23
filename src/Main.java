import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        JFrame windowMain = new JFrame("mainWindow");
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowMain.setSize(1500, 900);
        windowMain.setLocationRelativeTo(null);
        windowMain.setResizable(false);
        windowMain.setVisible(true);
        System.out.println("neco");

        Random rd = new Random();
        int heightRd = rd.nextInt(100,800);
        int widthRd = rd.nextInt(100,1400);
        JButton button = new JButton("button");
        button.addActionListener(e -> {
            System.out.println("Klik!");
        });
        windowMain.add(button);
        button.setBounds(widthRd,heightRd,100,100);
        windowMain.revalidate();





    }
}