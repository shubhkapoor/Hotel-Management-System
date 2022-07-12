package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class addEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1, b2;

    public addEmployee() {

        JLabel name = new JLabel("Name");
        name.setBounds(20, 30, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        t1 = new JTextField();
        t1.setBounds(160, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setBounds(20, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);

        t2 = new JTextField();
        t2.setBounds(160, 80, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(20, 130, 120, 30);
        gender.setBackground(Color.white);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        r1.setBounds(160, 130, 70, 30);
        r1.setBackground(Color.white);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        r2.setBounds(240, 130, 70, 30);
        r2.setBackground(Color.white);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        add(r1);
        add(r2);

        JLabel job = new JLabel("Job");
        job.setBounds(20, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);

        String[] str = {"Manager", "Accountant", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/waitress", "Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(160, 180, 150, 30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(20, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);

        t3 = new JTextField();
        t3.setBounds(160, 230, 150, 30);
        add(t3);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(20, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);

        t4 = new JTextField();
        t4.setBounds(160, 280, 150, 30);
        add(t4);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(20, 330, 120, 30);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(aadhar);

        t5 = new JTextField();
        t5.setBounds(160, 330, 150, 30);
        add(t5);

        JLabel email = new JLabel("Email");
        email.setBounds(20, 380, 120, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(email);

        t6 = new JTextField();
        t6.setBounds(160, 380, 150, 30);
        add(t6);

        b1 = new JButton("Submit");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(20, 430, 130, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(180, 430, 130, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\add_employee.jpg");
        Image i2 = i1.getImage().getScaledInstance(550, 620, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(300, 80, 500, 400);
        add(l1);

        JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 30));
        l2.setBounds(350, 20, 400, 35);
        add(l2);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(250, 150, 800, 520);
        setTitle("ADD EMPLOYEE");
        setVisible(true);
        setTitle("Add Employee Details");
        setResizable(false);

    }

    public static void main(String[] args) {

        new addEmployee().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone = t4.getText();
            String aadhar = t5.getText();
            String email = t6.getText();

            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String job = (String) c1.getSelectedItem();

            conn c = new conn();

            String str = "insert into employee values('" + name + "' , '" + age + "' , '" + gender + "' , '" + job + "' , '" + salary + "' , '" + phone + "' , '" + aadhar + "' , '" + email + "')";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added");
                this.setVisible(false);

            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }

    }

}
