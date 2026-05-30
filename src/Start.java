import javax.swing.*;

public class Start {

    private JFrame frame;
    private JButton[] buttons;

    public Start() {

        createWindow();
        createButtons();

        frame.setVisible(true);

    }

    private void createWindow() {

        frame = new JFrame("My Project");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createButtons() {

        buttons = new JButton[10];

        for (int i = 0; i < buttons.length; i++) {


            buttons[i] = new JButton("Button " + (i + 1));


            int x;
            int y;

            if (i < 5) {
                y = 300;
                x = 300 + i * 300;
            } else {
                y = 700;
                x = -1200 + i * 300;
            }
            buttons[i].setBounds(x, y, 200, 50);

            int index = i;

            buttons[i].addActionListener(e -> {
                for (int j = 0; j < buttons.length; j++) {
                    buttons[j].setVisible(false);
                }

                switch (index) {

                    case 0:
                        new games.FindButtongame(frame.getHeight(),frame.getWidth());

                }
            });

            frame.add(buttons[i]);
        }
    }
}