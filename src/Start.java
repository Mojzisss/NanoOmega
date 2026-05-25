//import javax.swing.*;
//
//public class MainWindow {
//
//    private JFrame frame;
//
//    // buttony jako fields
//    private JButton button1;
//    private JButton button2;
//    private JButton button3;
//    private JButton button4;
//    private JButton button5;
//    private JButton button6;
//    private JButton button7;
//    private JButton button8;
//    private JButton button9;
//    private JButton button10;
//
//    public MainWindow() {
//
//        createWindow();
//        createButtons();
//
//        frame.setVisible(true);
//    }
//
//    private void createWindow() {
//
//        frame = new JFrame("My Project");
//
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setLayout(null);
//
//        frame.setDefaultCloseOperation(
//                JFrame.EXIT_ON_CLOSE
//        );
//    }
//
//    private void createButtons() {
//
//        button1 = new JButton("Button 1");
//        button2 = new JButton("Button 2");
//        button3 = new JButton("Button 3");
//        button4 = new JButton("Button 4");
//        button5 = new JButton("Button 5");
//        button6 = new JButton("Button 6");
//        button7 = new JButton("Button 7");
//        button8 = new JButton("Button 8");
//        button9 = new JButton("Button 9");
//        button10 = new JButton("Button 10");
//
//        // pozice
//        button1.setBounds(50,50,150,50);
//        button2.setBounds(50,120,150,50);
//        button3.setBounds(50,190,150,50);
//        button4.setBounds(50,260,150,50);
//        button5.setBounds(50,330,150,50);
//
//        button6.setBounds(250,50,150,50);
//        button7.setBounds(250,120,150,50);
//        button8.setBounds(250,190,150,50);
//        button9.setBounds(250,260,150,50);
//        button10.setBounds(250,330,150,50);
//
//        // přidání do okna
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
//        frame.add(button4);
//        frame.add(button5);
//        frame.add(button6);
//        frame.add(button7);
//        frame.add(button8);
//        frame.add(button9);
//        frame.add(button10);
//
//        // zatím prázdné listenery
//        button1.addActionListener(e -> {
//
//        });
//
//        button2.addActionListener(e -> {
//
//        });
//
//        button3.addActionListener(e -> {
//
//        });
//
//        button4.addActionListener(e -> {
//
//        });
//
//        button5.addActionListener(e -> {
//
//        });
//
//        button6.addActionListener(e -> {
//
//        });
//
//        button7.addActionListener(e -> {
//
//        });
//
//        button8.addActionListener(e -> {
//
//        });
//
//        button9.addActionListener(e -> {
//
//        });
//
//        button10.addActionListener(e -> {
//
//        });
//    }
//}