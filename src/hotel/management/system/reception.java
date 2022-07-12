package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

    reception() {

        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(20, 30, 200, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room Details");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(20, 70, 200, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Employee Details");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(20, 110, 200, 30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Customer Details");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(20, 150, 200, 30);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Manager Details");
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setBounds(20, 190, 200, 30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Update Check Status");
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setBounds(20, 230, 200, 30);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setBounds(20, 270, 200, 30);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Room Status");
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setBounds(20, 310, 200, 30);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Pick-up Service");
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setBounds(20, 350, 200, 30);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Search Room");
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setBounds(20, 390, 200, 30);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Logout");
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(20, 430, 200, 30);
        b11.addActionListener(this);
        add(b11);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\reception.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(140, 10, 600, 470);
        add(l1);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(320, 150, 672, 520);
        setResizable(false);
        setTitle("Reception");
        setVisible(true);
    }

    public static void main(String[] args) {
        new reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            new addCustomer().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b2) {
            new roomDetails().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b3) {
            new employeeInfo().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b4) {
            new customerInfo().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b5) {
            new managerInfo().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b6) {
            new updateCheck().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b7) {
            new checkOut().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b8) {
            new updateRoom().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b9) {
            new pickup().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b10) {
            new searchRoom().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b11) {
            new login().setVisible(true);
            setVisible(false);
        }

    }

}
