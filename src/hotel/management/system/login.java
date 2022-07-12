package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {

    JTextField t1, t2;
    JLabel l1, l2;
    JButton b1, b2;

    login() {

        JLabel l0 = new JLabel("Log In");
        l0.setFont(new Font("Tahoma", Font.BOLD, 23));
        l0.setForeground(Color.black);
        l0.setBounds(120, 0, 200, 30);
        add(l0);

        l1 = new JLabel("Username");
        l1.setBounds(20, 45, 100, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(130, 50, 150, 22);
        add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(20, 95, 100, 30);
        add(l2);

        t2 = new JPasswordField();
        t2.setBounds(130, 100, 150, 22);
        add(t2);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(20, 160, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(160, 160, 120, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\login.jpg");
        Image i2 = i1.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(285, 10, 200, 200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(370, 180, 500, 260);
        setVisible(true);
        setResizable(false);
        setTitle("Login");
    }

    public static void main(String[] args) throws Exception {

        new login();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();

            String str = "select * from login where username='" + username + "' and password='" + password + "'";

            try {
                ResultSet rs = (ResultSet) c.s.executeQuery(str);

                if (rs.next()) {
                    new homepage().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            System.exit(0);
        }

    }

}
