package MessManagements;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;
import java.sql.*;
//import net.proteanit.sql.*;

public class Members extends JFrame {

    JTable table;

    Members() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("MEMBERS");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Team.png"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(500, 0, 600, 600);
        add(image);

        JLabel cms = new JLabel("ID");
        cms.setFont(new Font("Tahoma", Font.BOLD, 11));
        cms.setBounds(10, 10, 100, 20);
        add(cms);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.BOLD, 11));
        name.setBounds(90, 10, 100, 20);
        add(name);

        JLabel date = new JLabel("Date");
        date.setFont(new Font("Tahoma", Font.BOLD, 11));
        date.setBounds(190, 10, 100, 20);
        add(date);

        JLabel profess = new JLabel("Profession");
        profess.setFont(new Font("Tahoma", Font.BOLD, 11));
        profess.setBounds(270, 10, 100, 20);
        add(profess);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.BOLD, 11));
        email.setBounds(350, 10, 100, 20);
        add(email);

        JLabel amount = new JLabel("Amount");
        amount.setFont(new Font("Tahoma", Font.BOLD, 11));
        amount.setBounds(430, 10, 100, 20);
        add(amount);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Member");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(300, 200, 1050, 600);
        setVisible(true);
        setLocation(250, 100);

    }

    public static void main(String[] arg) {
        new Members();

    }
}
