package games;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FindButtongame implements ActionListener {

    private JButton button;
    private JFrame frame;
    private Random rd;

    private int clicked = 0;
    private int buttonSize;
    private final int frame_height;
    private final int frame_width;

    public FindButtongame(Integer frame_height,Integer frame_width) {
        this.frame_height = frame_height;
        this.frame_width = frame_width;
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        clicked++;
//
//        double random = rd.nextDouble(0.6, 0.9);
//        buttonSize = (int) (buttonSize * random);
//
//        int maxWidth = frame_width - buttonSize-50;
//        int maxHeight = frame_height - buttonSize-50;
//
//        int x = rd.nextInt(maxWidth)+25;
//        int y = rd.nextInt(maxHeight)+25;
//
//        button.setSize(buttonSize, buttonSize);
//        button.setLocation(x, y);
//
//        frame.add(button);
//        System.out.println(clicked);
//    }
}
