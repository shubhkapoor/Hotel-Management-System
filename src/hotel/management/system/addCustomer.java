package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class addCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1, r2;

    addCustomer() {

        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 27));
        l1.setBounds(30, 20, 400, 35);
        add(l1);

        JLabel l2 = new JLabel("ID Type");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l2.setBounds(20, 80, 160, 20);
        add(l2);

        c1 = new JComboBox(new String[]{"Passport", "Voter-id Card", "Driving Licence", "Aadhar Card"});
        c1.setBackground(Color.white);
        c1.setBounds(200, 80, 150, 20);
        add(c1);

        JLabel l3 = new JLabel("ID Number");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setBounds(20, 120, 160, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 120, 150, 20);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l4.setBounds(20, 160, 160, 20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 160, 150, 20);
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l5.setBounds(20, 200, 160, 20);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setBounds(200, 200, 60, 20);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(270, 200, 80, 20);
        add(r2);

        ButtonGroup br = new ButtonGroup();
        br.add(r1);
        br.add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l6.setBounds(20, 240, 160, 20);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(200, 240, 150, 20);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l7.setBounds(20, 280, 160, 20);
        add(l7);

        c2 = new Choice();

        try {
            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                c2.add(rs.getString("room_number"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        c2.setBounds(200, 280, 225, 20);
        add(c2);

        JLabel l8 = new JLabel("Checked In");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l8.setBounds(20, 320, 160, 20);
        add(l8);

        t4 = new JTextField();
        t4.setBounds(200, 320, 150, 20);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l9.setBounds(20, 360, 160, 20);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(200, 360, 150, 20);
        add(t5);

        b1 = new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50, 410, 120, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200, 410, 120, 25);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\add_customer.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(370, 30, 400, 400);
        add(l10);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(250, 150, 800, 500);
        setVisible(true);
        setResizable(false);
        setTitle("Add Customer");
    }

    public static void main(String[] args) {

        new addCustomer().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r1.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            try {

                String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";

                String str2 = "update room set available = 'Occupied' where room_number='" + room + "'";

                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "New Customer Added");
            new reception().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }

    }

}
