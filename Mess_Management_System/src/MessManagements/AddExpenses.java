package MessManagements;


import com.toedter.calendar.JDateChooser;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddExpenses extends JFrame implements ActionListener{ //Third Frame


    JTextField textField_1,textField_4,textField_5;
    JDateChooser textField_2;

    JButton Next;

    public AddExpenses(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EXPENSIONS DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);


        JLabel Pnrno = new JLabel("S.NO:");
        Pnrno.setFont(new Font("Tahoma", Font.BOLD, 17));
        Pnrno.setBounds(260, 80, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(400, 80, 150, 27);
        add(textField_1);

        JLabel Gender = new JLabel("DATE:");
        Gender.setFont(new Font("Tahoma", Font.BOLD, 17));
        Gender.setBounds(260, 130, 150, 27);
        add(Gender);

        textField_2 = new JDateChooser();
        textField_2.setBounds(400, 130, 150, 27);
        add(textField_2);



        JLabel PROFESSION = new JLabel("DISCRIPTION:");
        PROFESSION.setFont(new Font("Tahoma", Font.BOLD, 17));
        PROFESSION.setBounds(260, 180, 150, 27);
        add(PROFESSION);


        textField_4= new JTextField();
        textField_4.setBounds(400, 180, 150, 27);
        add(textField_4);

        JLabel amount = new JLabel("AMOUNT:");
        amount.setFont(new Font("Tahoma", Font.BOLD, 17));
        amount.setBounds(260, 230, 150, 27);
        add(amount);

        textField_5 = new JTextField();
        textField_5.setBounds(400, 230, 150, 27);
        add(textField_5);

        Next = new JButton("SAVE");
        Next.setBounds(400, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EXPENTIONS DETAILS");
        AddPassengers.setForeground(Color.BLACK);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(250, 24, 442, 35);
        add(AddPassengers);


//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel image = new JLabel(i2);
//        image.setBounds(410,80,480,410);
//        add(image);




        setSize(900,600);
        setVisible(true);
        setLocation(330,100);

    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == Next){
                try{
                    Conn c = new Conn();
                    String NO = textField_1.getText();
                    String DATE = ((JTextField) textField_2.getDateEditor().getUiComponent()).getText();
                    String discription = textField_4.getText();
                    String AMOUNT = textField_5.getText();


                    String str = "INSERT INTO Expension values('"+NO+"', '"+DATE+"','"+discription+"','"+AMOUNT+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Expensions Successfully Added");
                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }

        }catch(Exception eee){

        }}

    public static void main(String[] args){
        new AddExpenses();
    }
}