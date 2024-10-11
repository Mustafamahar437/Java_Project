package MessManagements;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class Dashboard extends JFrame implements ActionListener{
    JButton b1,b2;
    static double total_units=0;
    JTextField t2;
    JComboBox t1,t4,t5,t6;
    JDateChooser t3;
    JMenuItem addmember,INFO,addexpension,INFO2,units,addamount;
    public Dashboard() {
        super("HOSTEL MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null);

        JLabel AirlineManagementSystem = new JLabel("WELCOME TO IBA HOSTEL");
        AirlineManagementSystem.setForeground(Color.BLACK);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(400, 30, 1000, 85);
        add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("HOSTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLACK);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("Manager");
        FlightDetails.addActionListener(this);
        AirlineSystem.add(FlightDetails);

        INFO = new JMenuItem("MEMBERS INFO");
        INFO.addActionListener(this);
        AirlineSystem.add(INFO);

        INFO2 = new JMenuItem("EXPENSES INFO");
        INFO2.addActionListener(this);
        AirlineSystem.add(INFO2);

        units = new JMenuItem("UNITS INFO");
        units.addActionListener(this);
        AirlineSystem.add(units);

        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.BLACK);
        menuBar.add(AirlineSystemHello);

        addmember = new JMenuItem("ADD MEMBERS");
        addmember.addActionListener(this);
        AirlineSystemHello.add(addmember);


        addexpension = new JMenuItem("ADD EXPENSES");
        addexpension.addActionListener(this);
        AirlineSystemHello.add(addexpension);

        addamount = new JMenuItem("ADD AMOUNT");
        addamount.addActionListener(this);
        AirlineSystemHello.add(addamount);

        JLabel l1 = new JLabel("CMS ID:");
        l1.setBounds(190,150,100,30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        t1 = new JComboBox<>(new DefaultComboBoxModel<>());
        t1.setBounds(400,150,200,30);
        t1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        t1.setBackground(Color.white);
        add(t1);

        JLabel l2 = new JLabel("NAME:");
        l2.setBounds(190,200,100,30);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l2);

        t2=new JTextField();
        t2.setBounds(400,200,200,30);
        t2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(t2);

        JLabel l3 = new JLabel("DATE:");
        l3.setBounds(190,250,100,30);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l3);

        t3=new JDateChooser();
        t3.setBounds(400,250,200,30);
        t3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(t3);

        JLabel l4 = new JLabel("BREAK_FAST:");
        l4.setBounds(190,300,150,30);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l4);

        t4=new JComboBox(new String[]{"0","1","2","3","4","5"});
        t4.setBounds(400,300,200,30);
        t4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        t4.setBackground(Color.white);
        add(t4);

        JLabel l5 = new JLabel("LUNCH:");
        l5.setBounds(190,350,100,30);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l5);

        t5=new JComboBox(new String[]{"0","1","2","3","4","5"});
        t5.setBounds(400,350,200,30);
        t5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        t5.setBackground(Color.white);
        add(t5);

        JLabel l6 = new JLabel("DINNER:");
        l6.setBounds(190,400,100,30);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l6);

        t6=new JComboBox(new String[]{"0","1","2","3","4","5"});
        t6.setBounds(400,400,200,30);
        t6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        t6.setBackground(Color.white);
        add(t6);

        b1 = new JButton("Refresh");
        b1.setBounds(400,500,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Add");
        b2.setBounds(600,500,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c=new Conn();
            String id = (String) t1.getSelectedItem();
            String query1="select CMSD from Member";
            ResultSet rs=c.s.executeQuery(query1);
            while (rs.next()) {
                String name = rs.getString("CMSD");
                t1.addItem(name);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        t1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Conn co = new Conn();
                    String selectedId = (String) t1.getSelectedItem();
                    String query1 = "select NAME from Member where CMSD =?";
                    PreparedStatement preparedStatement = co.c.prepareStatement(query1);
                    preparedStatement.setString(1, selectedId);
                    ResultSet rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        t2.setText(rs.getString("NAME"));
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }});

        if (ae.getSource() == b1) {
            if(ae.getSource().equals("")){

            }
        }

        if (ae.getActionCommand().equals("ADD MEMBERS")) {
            new MessManagements.AddMember();
        } else if (ae.getActionCommand().equals("MEMBERS INFO")) {
            new MessManagements.Members();
        } else if (ae.getActionCommand().equals("ADD EXPENSES")) {
            new MessManagements.AddExpenses();
        } else if (ae.getActionCommand().equals("EXPENSES INFO")) {
            new MessManagements.Expenses();
        } else if(ae.getActionCommand().equals("ADD AMOUNT")){
            new MessManagements.AddAmount();
        } else if(ae.getActionCommand().equals("UNITS INFO")){
            new MessManagements.Units();
        }else if(ae.getActionCommand().equals("Manager")){
            new MessManagements.MessManager();
        }

        try{

            if(ae.getSource() == b2){
                try{
                    Conn c = new Conn();
                    String id = (String) t1.getSelectedItem();
                    String name = t2.getText();
                    String date = ((JTextField) t3.getDateEditor().getUiComponent()).getText();
                    String BF = (String) t4.getSelectedItem();
                    String lunch = (String) t5.getSelectedItem();
                    String dinner = (String) t6.getSelectedItem();
                  //  total_units=(int)t4.getSelectedItem()+(int)t5.getSelectedItem()+(int)t6.getSelectedItem();
                    String str = "INSERT INTO Units values( '" + id + "', '" + name + "', '" + date + "','" + BF + "', '" + lunch + "','" + dinner + "')";
                    String str1 = "INSERT INTO Balance (unit) " + "VALUES('" + (BF + lunch + dinner) + "')";
                    c.s.executeUpdate(str1);
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Units Successfully Added");
                   // this.setVisible(false);
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }

        }catch(Exception eee){

        }
    }



    public static void main(String[] args) {
        new Dashboard();

    }}