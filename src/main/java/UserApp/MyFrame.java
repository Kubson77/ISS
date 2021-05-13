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
        ImageIcon imageIcon = new ImageIcon("logo.jpg");
        setIconImage(imageIcon.getImage());
    }
}

class ButtonPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 500;
    public static final int WIDTH = 1000;
    Dao dao = new Dao();
    private JButton getSpeedButton;
    private JButton astronautsNum;
    private JButton locationButton;
    private JButton avgSpeedBut;
    private JButton astroList;


    public ButtonPanel() {
        locationButton = new JButton("Last Location");
        getSpeedButton = new JButton("Speed of ISS");
        astronautsNum = new JButton("Astronauts Number");
        avgSpeedBut = new JButton("Average Speed");
        astroList = new JButton("Astronauts List");

        locationButton.addActionListener(this);
        getSpeedButton.addActionListener(this);
        astronautsNum.addActionListener(this);
        avgSpeedBut.addActionListener(this);
        astroList.addActionListener(this);

        setLayout(new GridLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(locationButton);
        add(getSpeedButton);
        add(astronautsNum);
        add(avgSpeedBut);
        add(astroList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        if (source == locationButton) {
            String msg = String.format("Longitude: " + dao.getLastIssCoordinates().getLongitude() + " Latitude: "
                    + dao.getLastIssCoordinates().getLatitude());
            JOptionPane.showMessageDialog(null, msg);
        } else if (source == getSpeedButton) {
            String speedMsg = String.format("Speed: " + dao.getLastIssCoordinates().getSpeed() + " km/h");
            JOptionPane.showMessageDialog(null, speedMsg);
        } else if (source == astronautsNum) {
            String astronautsMsg = String.format("Astronauts: " + dao.getHowManyPeopleInIss().toString());
            JOptionPane.showMessageDialog(null, astronautsMsg);
        } else if (source == avgSpeedBut) {
            String avgSpdMsg = String.format("Average Speed: " + dao.getAverageSpeed() + " km/h");
            JOptionPane.showMessageDialog(null, avgSpdMsg);
        } else if (source == astroList) {
            JOptionPane.showMessageDialog(null, dao.getAstronauts());
        }
    }
}
