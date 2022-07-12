package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class searchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1, b2;
    JTable t1;

    searchRoom() {

        JLabel l1 = new JLabel("Search for Room");
        l1.setFont(new Font("Tahoma", Font.BOLD, 25));
        l1.setBounds(270, 5, 300, 30);
        add(l1);

        JLabel l2 = new JLabel("Select Bed Type");
        l2.setForeground(Color.black);
        l2.setBounds(150, 70, 100, 20);
        add(l2);

        c1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setBounds(260, 70, 100, 20);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Only Display Available Room");
        c2.setBackground(Color.white);
        c2.setForeground(Color.black);
        c2.setBounds(450, 70, 200, 20);
        add(c2);

        t1 = new JTable();
        t1.setBounds(5, 150, 790, 300);
        add(t1);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(250, 470, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(410, 470, 120, 30);
        b2.addActionListener(this);
        add(b2);

        JLabel l3 = new JLabel("Room Number");
        l3.setForeground(Color.black);
        l3.setBounds(50, 120, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Availability");
        l4.setForeground(Color.black);
        l4.setBounds(220, 120, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Cleaning Status");
        l5.setForeground(Color.black);
        l5.setBounds(360, 120, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setForeground(Color.black);
        l6.setBounds(540, 120, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setForeground(Color.black);
        l7.setBounds(680, 120, 100, 20);
        add(l7);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Room Status");
        setBounds(235, 130, 800, 550);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        new searchRoom().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {

                String str = "select * from room where bed_type = '" + c1.getSelectedItem() + "'";
                String str2 = "select * from room where available ='Available' AND bed_type = '" + c1.getSelectedItem() + "'";

                conn c = new conn();

                if (c2.isSelected()) {
                    ResultSet rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

            } catch (Exception e1) {
                System.out.println(e1);
            }

        } else if (e.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }

    }

}
