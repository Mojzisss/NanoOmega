//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//
//public class FindButtongame implements ActionListener {
//
//    private JButton button;
//    private JFrame windowMain;
//    private int windowwidth;
//    private int windowheight;
//    private Random rd;
//    private int clicked = 0;
//
//    public FindButtongame(JButton button, JFrame windowMain,int windowvidth ,int windowheight, Random rd) {
//        this.button = button;
//        this.windowMain = windowMain;
//        this.windowwidth = windowvidth;
//        this.windowheight = windowheight;
//        this.rd = rd;
//    }
//
//    private int widthButton = windowwidth-100;
//    private int heightButton = windowheight-100;
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        clicked++;
//        double randomwidth = rd.nextDouble(0.3, 0.9);
//        double randomheight = rd.nextDouble(0.3, 0.9);
//
//        widthButton =(int)(widthButton * randomwidth);
//        heightButton =(int)(heightButton * randomheight);
//
//        int maxWidth = windowMain.getWidth() - button.getWidth();
//        int maxHeight = windowMain.getHeight() - button.getHeight();
//
//        int x = rd.nextInt(maxWidth);
//        int y = rd.nextInt(maxHeight);
//
//        button.setLocation(x, y);
//        button.setSize(heightButton, widthButton);
//
//        System.out.println(clicked);
//    }
//}
//
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FindButtongame implements ActionListener {

    private JButton button;
    private JFrame windowMain;
    private Random rd;

    private int clicked = 0;

    private int buttonSize = 100;

    public FindButtongame(
            JButton button,
            JFrame windowMain,
            Random rd
    ) {
        this.button = button;
        this.windowMain = windowMain;
        this.rd = rd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        clicked++;

        double random = rd.nextDouble(0.3, 0.9);

        buttonSize = (int) (buttonSize * random);

        int maxWidth =
                windowMain.getWidth() - buttonSize;

        int maxHeight =
                windowMain.getHeight() - buttonSize;

        int x = rd.nextInt(maxWidth);
        int y = rd.nextInt(maxHeight);

        button.setSize(buttonSize, buttonSize);
        button.setLocation(x, y);

        System.out.println(clicked);
    }
}