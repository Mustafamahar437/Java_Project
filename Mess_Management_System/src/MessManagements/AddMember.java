package MessManagements;


import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddMember extends JFrame implements ActionListener{ //Third Frame
    int sumnum=1;
    static double Total_Amount=0;
    JTextField textField,textField_1,textField_4,textField_5;
    JDateChooser textField_2;
    JComboBox textField_3;
    JButton Next;

    public AddMember(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD MEMBER DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel cms = new JLabel("CMS ID:");
        cms.setFont(new Font("Tahoma", Font.BOLD, 17));
        cms.setBounds(60, 30, 150, 27);
        add(cms);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);


        JLabel Pnrno = new JLabel("NAME:");
        Pnrno.setFont(new Font("Tahoma", Font.BOLD, 17));
        Pnrno.setBounds(60, 80, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Gender = new JLabel("DATE:");
        Gender.setFont(new Font("Tahoma", Font.BOLD, 17));
        Gender.setBounds(60, 130, 150, 27);
        add(Gender);

        textField_2 = new JDateChooser();
        textField_2.setBounds(200, 130, 150, 27);
        add(textField_2);



        JLabel PROFESSION = new JLabel("PROFESSION:");
        PROFESSION.setFont(new Font("Tahoma", Font.BOLD, 17));
        PROFESSION.setBounds(60, 180, 150, 27);
        add(PROFESSION);


        textField_3= new JComboBox(new String[] {"Teacher","Student"});
        textField_3.setBounds(200, 180, 150, 27);
        add(textField_3);


        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("Tahoma", Font.BOLD, 17));
        email.setBounds(60, 230, 150, 27);
        add(email);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 230, 150, 27);
        add(textField_4);

        JLabel amount = new JLabel("AMOUNT:");
        amount.setFont(new Font("Tahoma", Font.BOLD, 17));
        amount.setBounds(60, 280, 150, 27);
        add(amount);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 280, 150, 27);
        add(textField_5);

        Next = new JButton("SAVE");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD MEMBER DETAILS");
        AddPassengers.setForeground(Color.BLACK);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);




        setSize(900,600);
        setVisible(true);
        setLocation(530,200);

    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == Next){
                try{
                    Conn c = new Conn();
                    String CMSD = textField.getText();
                    String NAME = textField_1.getText();
                    String DATE = ((JTextField) textField_2.getDateEditor().getUiComponent()).getText();
                    String PROFESS = (String)textField_3.getSelectedItem();
                    String EMAIL = textField_4.getText();
                    String AMOUNT = textField_5.getText();

                    Total_Amount += Double.parseDouble(textField_5.getText());
                    String str = "INSERT INTO Member values( '"+CMSD+"', '"+NAME+"', '"+DATE+"','"+PROFESS+"', '"+EMAIL+"','"+AMOUNT+"')";
                    String str1= "INSERT INTO Tamount values('"+Total_Amount+"')";
                    String str2="INSERT INTO allmember values('"+sumnum+"')";
                    c.s.executeUpdate(str2);
                    c.s.executeUpdate(str1);
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Member Successfully Added");


                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                    JOptionPane.showMessageDialog(this, "Error retrieving data: " + ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }catch(Exception eee){

        }}

    public static void main(String[] args){
        new AddMember();
    }
}