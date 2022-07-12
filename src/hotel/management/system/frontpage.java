package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frontpage extends JFrame implements ActionListener {

    frontpage() {
        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\frontpage.png");
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1000, 600);
        add(l1);

        JButton b1 = new JButton("Admin Login");
        b1.setBounds(20, 30, 120, 35);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setBounds(130, 60, 1000, 600);
        setResizable(false);
        setTitle("Welcome");
        setVisible(true);
    }

    public static void main(String[] args) {
        new frontpage().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new login().setVisible(true);
        this.setVisible(false);
    }
}
