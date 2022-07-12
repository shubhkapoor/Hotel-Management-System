package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addRooms extends JFrame implements ActionListener {

    JTextField t1, t2;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    addRooms() {

        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setBounds(90, 20, 400, 35);
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setBounds(30, 80, 120, 30);
        room.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(room);

        t1 = new JTextField();
        t1.setBounds(170, 80, 150, 30);
        add(t1);

        JLabel available = new JLabel("Rooms Available");
        available.setBounds(30, 130, 120, 30);
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(available);

        c1 = new JComboBox(new String[]{"Available", "Occupied"});
        c1.setBounds(170, 130, 150, 30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel status = new JLabel("Cleaning Status");
        status.setBounds(30, 180, 120, 30);
        status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(status);

        c2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        c2.setBounds(170, 180, 150, 30);
        c2.setBackground(Color.white);
        add(c2);

        JLabel price = new JLabel("Rooms Price");
        price.setBounds(30, 230, 120, 30);
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(price);

        t2 = new JTextField();
        t2.setBounds(170, 230, 150, 30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(30, 280, 120, 30);
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(type);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c3.setBounds(170, 280, 150, 30);
        c3.setBackground(Color.white);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(30, 350, 130, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(190, 350, 130, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\add_room.jpeg");
        Image i2 = i1.getImage().getScaledInstance(410, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l5 = new JLabel(i3);
        l5.setBounds(300, 5, 500, 400);
        add(l5);

        getContentPane().setBackground(Color.white);

        setBounds(250, 150, 800, 450);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Add Room Details");

    }

    public static void main(String[] args) {

        new addRooms().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();

            conn c = new conn();

            try {
                String str = "insert into room values( '" + room + "','" + available + "','" + status + "','" + price + "','" + type + "')";
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);
            } catch (Exception e1) {
                System.out.println(e);
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
        }

    }

}
