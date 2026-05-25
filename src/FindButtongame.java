
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FindButtongame implements ActionListener {

    private JButton button;
    private JFrame windowMain;
    private Random rd;

    private int clicked = 0;
    private int buttonSize ;

    public FindButtongame(JButton button, JFrame windowMain, Random rd , Integer buttonSize) {
        this.button = button;
        this.windowMain = windowMain;
        this.rd = rd;
        this.buttonSize=buttonSize;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicked++;

        double random = rd.nextDouble(0.6, 0.9);
        buttonSize = (int) (buttonSize * random);

        int maxWidth = windowMain.getWidth() - buttonSize;
        int maxHeight = windowMain.getHeight() - buttonSize;

        int x = rd.nextInt(maxWidth);
        int y = rd.nextInt(maxHeight);

        button.setSize(buttonSize, buttonSize);
        button.setLocation(x, y);

        System.out.println(clicked);
    }
}