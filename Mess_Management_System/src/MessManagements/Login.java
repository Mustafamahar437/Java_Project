package MessManagements;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;

    Login() {

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Signup");
        b3.setBounds(110, 190, 120, 30);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600, 300);
        setLocation(600, 350);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                Conn c1 = new Conn();
                String username = t1.getText();
                String passwords = t2.getText();
                String q = "select * from login where username = '" + username + "' and password = '" + passwords + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect USERNAME or PASSWORD");
                }
            } else if (ae.getSource() == b2) {
                t1.setText("");
                t2.setText("");
            } else if (ae.getSource() == b3) {
                setVisible(false);
                new Signup().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {

        new Login();
    }
}
