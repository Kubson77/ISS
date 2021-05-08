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
    private JButton getSpeedButton;
    private JButton redButton;
    private JButton locationButton;

    public ButtonPanel() {
        locationButton = new JButton("Last Location");
        getSpeedButton = new JButton("Speed of ISS");
        redButton = new JButton("Red");

        locationButton.addActionListener(this);
        getSpeedButton.addActionListener(this);
        redButton.addActionListener(this);

        setLayout(new GridLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(locationButton);
        add(getSpeedButton);
        add(redButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == locationButton) {
            String msg = String.format("Longitude: " + dao.getLastIssCoordinates().getLongitude() + " Latitude: "
                    + dao.getLastIssCoordinates().getLatitude());
            JOptionPane.showMessageDialog(null, msg);
        } else if (source == getSpeedButton) {
            String speedMsg = String.format("Speed: " + dao.getLastIssCoordinates().getSpeed() + "km/h");
            JOptionPane.showMessageDialog(null, speedMsg);
        }
        else if (source == redButton) {
            setBackground(Color.RED);
        }
    }
}
