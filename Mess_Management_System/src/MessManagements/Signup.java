package MessManagements;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
    
    JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b,b1;
    JDateChooser dateChooser;
    String rand;
    
    


    
    Signup(){
        
        setTitle("NEW ADMIN FORM");
        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l11 = new JLabel(i3);
//        l11.setBounds(20, 0, 100, 100);
//        add(l11);
        
        l2 = new JLabel(" Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(290,80,600,30);
        add(l2);

        
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100,140,100,30);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300,140,400,30);
        add(t1);

        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100,190,200,30);
        add(l4);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300,190,400,30);
        add(t2);

        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100,240,200,30);
        add(l5);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 200, 20);
        add(dateChooser);

        l6 = new JLabel("PHONE NUMBER:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100,290,200,30);
        add(l6);

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        t4.setBounds(300,290,400,30);
        add(t4);


        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100,340,200,30);
        add(l7);

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        t5.setBounds(300,340,400,30);
        add(t5);

        l8 = new JLabel("HOSTEL NAME:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100,390,200,30);
        add(l8);

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t6.setBounds(300,390,400,30);
        add(t6);

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100,440,200,30);
        add(l9);

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        t7.setBounds(300,440,400,30);
        add(t7);

        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100,490,200,30);
        add(l10);

        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));
        t8.setBounds(300,490,400,30);
        add(t8);



        b = new JButton("Submit");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(600,560,100,30);
        b.addActionListener(this);
        add(b);

        b1 = new JButton("Exit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,560,100,30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,700);
        setLocation(300,0);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
        Random ra=new Random();
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String Phone=t4.getText();
        String email = t5.getText();
        String Hostel = t6.getText();
        String Address = t7.getText();
        String city = t8.getText();
        int ran=ra.nextInt(9000)+1111;
         rand=String.valueOf(ran);
        try{
            if(ae.getSource()==b){
            if(t6.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{

                Conn c1 = new Conn();
                String q1 = "insert into signup values('"+name+"','"+fname+"','"+dob+"','"+Phone+"','"+email+"','"+Hostel+"','"+Address+"','"+city+"')";
                c1.s.executeUpdate(q1);

                String q2="insert into Login values('"+name+"','"+rand+"')";
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Username : "+name+"  Passwoard :"+ rand);
                //new Signup2(first).setVisible(true);
                setVisible(false);
            }}else if(ae.getSource()==b1){
                setVisible(false);
                new Login().setVisible(true);
            }

        }catch(Exception e){
             e.printStackTrace();
        }

   }
    
    
    public static void main(String[] args){
        new Signup();
    }
}