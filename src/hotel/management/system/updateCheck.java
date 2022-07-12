package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class updateCheck extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5;
    Choice c1;

    updateCheck() {

        JLabel l1 = new JLabel("CHECK-IN DETAILS");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 27));
        l1.setBounds(60, 20, 400, 35);
        add(l1);

        JLabel l2 = new JLabel("Customer-ID");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l2.setBounds(30, 80, 100, 20);
        add(l2);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {
                c1.add(rs.getString("number"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        c1.setBounds(200, 80, 235, 25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setBounds(30, 120, 100, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 120, 160, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l4.setBounds(30, 160, 100, 20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 160, 160, 25);
        add(t2);

        JLabel l5 = new JLabel("Check-In");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l5.setBounds(30, 200, 150, 20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200, 200, 160, 25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l6.setBounds(30, 240, 150, 20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200, 240, 160, 25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l7.setBounds(30, 280, 150, 20);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200, 280, 160, 25);
        add(t5);

        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30, 340, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(140, 340, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(260, 340, 100, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\check-in-out.jpg");
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(310, 20, 450, 360);
        add(l8);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(290, 150, 720, 430);
        setVisible(true);
        setResizable(false);
        setTitle("Update Check-in Details");
    }

    public static void main(String[] args) {

        new updateCheck().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {

                conn c = new conn();

                String id = c1.getSelectedItem();
                String str = "select * from customer where number='" + id + "'";
                String room = null;
                String deposit = null;
                int amountPaid;
                String price = null;

                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number='" + room + "'");

                while (rs2.next()) {
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }

            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else if (e.getSource() == b2) {

            try {
                conn c = new conn();

                String s1 = c1.getSelectedItem();
                String s2 = t1.getText(); //room_number;    
                String s3 = t2.getText(); //name    
                String s4 = t3.getText(); //status;    
                String s5 = t4.getText(); //deposit    

                c.s.executeUpdate("update customer set room = '" + s2 + "', name = '" + s3 + "', status = '" + s4 + "', deposit = '" + s5 + "' where number = '" + s1 + "'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                new reception().setVisible(true);
                setVisible(false);
            } catch (Exception ee) {
                System.out.println(ee);
            }

        } else if (e.getSource() == b3) {
            new reception().setVisible(true);
            this.setVisible(false);
        }

    }

}
