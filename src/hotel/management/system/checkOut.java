package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class checkOut extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1, b2, b3;

    checkOut() {
        JLabel l1 = new JLabel("CHECK-OUT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 27));
        l1.setBounds(90, 20, 400, 35);
        add(l1);

        JLabel l2 = new JLabel("Customer Id");
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
        c1.setBounds(150, 80, 235, 25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setBounds(30, 130, 100, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(150, 125, 160, 25);
        add(t1);

        b1 = new JButton("Check-out");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30, 200, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(170, 200, 120, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\tick.png");
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(310, 80, 20, 20);
        add(b3);

        ImageIcon i4 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\check_out.jpg");
        Image i5 = i4.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(270, 10, 450, 230);
        add(l4);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(290, 180, 680, 300);
        setVisible(true);
        setTitle("Check-out");
    }

    public static void main(String[] args) {

        new checkOut().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number='" + id + "'";
            String str2 = "update room set available ='Available' where room_number ='" + room + "'";
            conn c = new conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "Checkout done");
                new reception().setVisible(true);
                this.setVisible(false);
            } catch (Exception e1) {
                System.out.println(e1);
            }

        } else if (e.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b3) {
            conn c = new conn();
            String id = c1.getSelectedItem();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number='" + id + "'");
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

        }

    }

}
