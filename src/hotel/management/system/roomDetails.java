package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class roomDetails extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    roomDetails() {

        JLabel l1 = new JLabel("Room Details");
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setForeground(Color.black);
        l1.setBounds(160, 10, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Room number");
        l2.setForeground(Color.black);
        l2.setBounds(15, 75, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Availability");
        l3.setForeground(Color.black);
        l3.setBounds(130, 75, 80, 20);
        add(l3);

        JLabel l4 = new JLabel("Status");
        l4.setForeground(Color.black);
        l4.setBounds(250, 75, 80, 20);
        add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setForeground(Color.black);
        l5.setBounds(360, 75, 60, 20);
        add(l5);

        JLabel l6 = new JLabel("Bed Type");
        l6.setForeground(Color.black);
        l6.setBounds(450, 75, 100, 20);
        add(l6);

        t1 = new JTable();
        t1.setBounds(5, 100, 535, 350);
        add(t1);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(140, 460, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(290, 460, 120, 30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(350, 135, 550, 550);
        setResizable(false);
        setTitle("Room Details");
        setVisible(true);

    }

    public static void main(String[] args) {

        new roomDetails().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {
                conn c = new conn();

                String str = "select * from room";
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
