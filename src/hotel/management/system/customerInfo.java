package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class customerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    customerInfo() {
        t1 = new JTable();
        t1.setBounds(2, 100, 984, 400);
        add(t1);

        JLabel l0 = new JLabel("Customer Details");
        l0.setFont(new Font("Tahoma", Font.BOLD, 30));
        l0.setForeground(Color.black);
        l0.setBounds(340, 10, 600, 40);
        add(l0);

        JLabel l1 = new JLabel("Document Type");
        l1.setForeground(Color.black);
        l1.setBounds(15, 75, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setForeground(Color.black);
        l2.setBounds(160, 75, 70, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setForeground(Color.black);
        l3.setBounds(290, 75, 70, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setForeground(Color.black);
        l4.setBounds(410, 75, 70, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setForeground(Color.black);
        l5.setBounds(530, 75, 70, 20);
        add(l5);

        JLabel l6 = new JLabel("Room Number");
        l6.setForeground(Color.black);
        l6.setBounds(635, 75, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Check-in");
        l7.setForeground(Color.black);
        l7.setBounds(775, 75, 70, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setForeground(Color.black);
        l8.setBounds(900, 75, 70, 20);
        add(l8);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(350, 520, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(530, 520, 120, 30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
        setBounds(140, 70, 1000, 600);
        setTitle("Customer Details");
        setVisible(true);
    }

    public static void main(String[] args) {
        new customerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {

                conn c = new conn();
                String str = "SELECT * FROM customer;";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e1) {
                System.out.println(e1);
            }

        } else if (e.getSource() == b2) {

            new reception().setVisible(true);
            this.setVisible(false);

        }

    }

}
