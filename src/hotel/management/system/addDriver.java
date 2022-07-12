package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class addDriver extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox c1, c2;

    addDriver() {

        JLabel title = new JLabel("ADD DRIVERS");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(80, 20, 400, 35);
        add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        name.setBounds(30, 70, 100, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(170, 70, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        age.setBounds(30, 110, 100, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(170, 110, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gender.setBounds(30, 150, 100, 30);
        add(gender);

        c1 = new JComboBox(new String[]{"Male", "Female"});
        c1.setBackground(Color.white);
        c1.setBounds(170, 150, 150, 30);
        add(c1);

        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tahoma", Font.PLAIN, 16));
        car.setBounds(30, 190, 100, 30);
        add(car);

        t3 = new JTextField();
        t3.setBounds(170, 190, 150, 30);
        add(t3);

        JLabel model = new JLabel("Model");
        model.setFont(new Font("Tahoma", Font.PLAIN, 16));
        model.setBounds(30, 230, 100, 30);
        add(model);

        t4 = new JTextField();
        t4.setBounds(170, 230, 150, 30);
        add(t4);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(30, 270, 100, 30);
        add(available);

        c2 = new JComboBox(new String[]{"Available", "Not Available"});
        c2.setBackground(Color.white);
        c2.setBounds(170, 270, 150, 30);
        add(c2);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(30, 310, 100, 30);
        add(location);

        t5 = new JTextField();
        t5.setBounds(170, 310, 150, 30);
        add(t5);

        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30, 370, 140, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180, 370, 140, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\add_driver.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(300, 10, 500, 400);
        add(l1);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(250, 150, 790, 470);
        setVisible(true);
        setResizable(false);
        setTitle("Add Driver Details");
    }

    public static void main(String[] args) {

        new addDriver().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String) c2.getSelectedItem();
            String location = t5.getText();

            conn c = new conn();

            String str = "Insert into driver values( '" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                this.setVisible(false);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
        }

    }

}
