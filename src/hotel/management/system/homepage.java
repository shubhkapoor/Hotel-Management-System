package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class homepage extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4;

    homepage() {

        mb = new JMenuBar();
        add(mb);

        m1 = new JMenu("MANAGEMENT");
        m1.setForeground(Color.DARK_GRAY);
        mb.add(m1);

        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.DARK_GRAY);
        mb.add(m2);

        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0, 0, 1294, 30);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\img\\homepage.jpg");
        Image i2 = i1.getImage().getScaledInstance(1300, 688, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1300, 690);
        add(l1);

        JLabel l2 = new JLabel("A LEMON TREE RESORT WELCOMES YOU!");
        l2.setBounds(200, 50, 1000, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        l1.add(l2);

        setLayout(null);
        setTitle("WELCOME");
        setBounds(-7, -1, 1294, 688);
        setVisible(true);

    }

    public static void main(String[] args) throws Exception {

        new homepage().setVisible(true);;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("RECEPTION")) {
            new reception().setVisible(true);
        } else if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new addEmployee().setVisible(true);
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new addRooms().setVisible(true);
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new addDriver().setVisible(true);
        }

    }

}
