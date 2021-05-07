package UserApp;

import dao.Dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("ISS Tracker");

        JPanel buttonPanel = new ButtonPanel();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

class ButtonPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 500;
    public static final int WIDTH = 1500;
    Dao dao = new Dao();
    private JButton blueButton;
    private JButton redButton;
    private JButton locationButton;

    public ButtonPanel() {
        locationButton = new JButton("Last Location");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        locationButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);

        setLayout(new GridLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(locationButton);
        add(blueButton);
        add(redButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == locationButton) {
            System.out.println("Latitude");
            System.out.println(dao.getLastIssCoordinates().getLatitude());
            System.out.println("Longitude");
            System.out.println(dao.getLastIssCoordinates().getLongitude());
            String msg = String.format("Longitude: " + dao.getLastIssCoordinates().getLongitude() + " Latitude: "
                    + dao.getLastIssCoordinates().getLatitude());
            JOptionPane.showMessageDialog(null, msg);
        } else if (source == blueButton)
            setBackground(Color.BLUE);

        else if (source == redButton)
            setBackground(Color.RED);
    }
}
