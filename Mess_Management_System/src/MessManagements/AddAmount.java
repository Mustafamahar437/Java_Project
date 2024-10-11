package MessManagements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

public class AddAmount extends JFrame implements ActionListener {
    JButton b1;
    TextField t1,t2;
    JDateChooser t;
    public AddAmount(){
        setLayout(null);
        setSize(600,500);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300,200);
        setTitle("ADD AMOUNT");

        JLabel date=new JLabel("DATE:");
        date.setFont(new Font("Tahoma",Font.BOLD,15));
        date.setBounds(25,80,150,20);
        add(date);

        t=new JDateChooser();
        t.setBounds(180,80,150,25);
        add(t);

        JLabel cms=new JLabel("CMS ID:");
        cms.setFont(new Font("Tahoma",Font.BOLD,15));
        cms.setBounds(25,140,100,20);
        add(cms);

        t1=new TextField();
        t1.setBounds(180,140,150,20);
        add(t1);


        JLabel amount=new JLabel("Enter Amount:");
        amount.setFont(new Font("Tahoma",Font.BOLD,15));
        amount.setBounds(25,200,130,20);
        add(amount);

        t2=new TextField();
        t2.setBounds(180,200,150,20);
        add(t2);

        b1=new JButton("SAVE");
        b1.setBounds(300,300,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        setVisible(true);

    }public void actionPerformed(ActionEvent ae) {
        try {
            if(ae.getSource()==b1) {
                Conn c = new Conn();
                String cms = t1.getText();
                String date = ((JTextField) t.getDateEditor().getUiComponent()).getText();
                String amountStr = t2.getText();
                double newAmount = Double.parseDouble(amountStr);

                // Insert the amount into the addamount table
                String insertQuery = "INSERT INTO addamount VALUES ('" + cms + "', '" + date + "', " + newAmount + ")";
                c.s.executeUpdate(insertQuery);
                JOptionPane.showMessageDialog(null, "Amount added successfully.");

                // Retrieve the current amount for the CMS ID from the member table
                ResultSet rs = c.s.executeQuery("SELECT AMOUNT FROM member WHERE CMSD='" + cms + "'");
                if (rs.next()) {
                    double currentAmount = rs.getDouble("amount");
                    double totalAmount = currentAmount + newAmount;

                    // Update the amount for the matching CMS ID
                    String updateQuery = "UPDATE member SET AMOUNT=" + totalAmount + " WHERE CMSD='" + cms + "'";
                    c.s.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "Amount Updated Successfully for CMS ID: " + cms);
                } else {
                    JOptionPane.showMessageDialog(null, "CMS ID not found in the member table.");
                }
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public static void main(String[] args){
        new AddAmount();

    }
}
