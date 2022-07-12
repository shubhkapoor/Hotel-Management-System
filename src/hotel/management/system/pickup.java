package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class pickup extends JFrame implements ActionListener {

    Choice c1;
    JCheckBox c2;
    JButton b1, b2;
    JTable t1;

    pickup() {

        JLabel l1 = new JLabel("Pick-up Service");
        l1.setFont(new Font("Tahoma", Font.BOLD, 25));
        l1.setBounds(300, 5, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setForeground(Color.black);;
        l2.setBounds(300, 70, 70, 20);
        add(l2);

        c1 = new Choice();
        try {

            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {

                c1.add(rs.getString("brand"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        c1.setBounds(390, 70, 170, 20);
        add(c1);

        t1 = new JTable();
        t1.setBounds(5, 150, 790, 300);
        add(t1);

        b1 = new JButton("Submit");
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

        JLabel l3 = new JLabel("Name");
        l3.setForeground(Color.black);
        l3.setBounds(45, 120, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setForeground(Color.black);
        l4.setBounds(160, 120, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setForeground(Color.black);
        l5.setBounds(270, 120, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Company");
        l6.setForeground(Color.black);
        l6.setBounds(370, 120, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Brand");
        l7.setForeground(Color.black);
        l7.setBounds(490, 120, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Availability");
        l8.setForeground(Color.black);
        l8.setBounds(590, 120, 100, 20);
        add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setForeground(Color.black);
        l9.setBounds(705, 120, 100, 20);
        add(l9);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Pick-up Service");
        setBounds(235, 130, 800, 550);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        new pickup().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {

                String str = "select * from driver where brand = '" + c1.getSelectedItem() + "'";
                conn c = new conn();

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
