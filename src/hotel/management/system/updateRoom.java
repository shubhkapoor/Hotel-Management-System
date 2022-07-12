package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class updateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

    updateRoom() {

        JLabel l1 = new JLabel("UPDATE ROOM STATUS");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 27));
        l1.setBounds(23, 20, 400, 35);
        add(l1);

        JLabel l2 = new JLabel("Guest ID");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l2.setBounds(20, 80, 120, 30);
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
        c1.setBounds(200, 80, 220, 25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setBounds(20, 130, 120, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 130, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l4.setBounds(20, 180, 120, 30);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 180, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l5.setBounds(20, 230, 120, 30);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 25);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(130, 300, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(40, 350, 120, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(220, 350, 120, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\update_room_status.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(350, 10, 450, 380);
        add(l6);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(250, 150, 810, 440);
        setVisible(true);
        setResizable(false);
        setTitle("Update Room Status");
    }

    public static void main(String[] args) {

        new updateRoom().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            String s1 = c1.getSelectedItem();

            String room_number = null;

            conn c = new conn();

            try {

                ResultSet rs = c.s.executeQuery("select * from customer where number = '" + s1 + "'");

                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                    room_number = rs.getString("room");
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + room_number + "'");

                while (rs2.next()) {
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                }

            } catch (Exception e1) {

                e1.printStackTrace();
            }

        } else if (e.getSource() == b2) {

            try {

                conn c = new conn();
                String room_number = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update room set available ='" + available + "',status='" + status + "' where room_number = '" + room_number + "'";

                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                new reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e1) {

                e1.printStackTrace();
            }

        } else if (e.getSource() == b3) {
            new reception().setVisible(true);
            this.setVisible(false);
        }

    }

}
