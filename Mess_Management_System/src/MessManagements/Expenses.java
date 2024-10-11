package MessManagements;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Expenses extends JFrame {
    JTable table;
    static double TotalA,TotalC,Remaining;
   static JLabel Total_Amount, Current_Amount,Balance;

    Expenses() {
        this.getContentPane().setBackground(Color.white);
        this.setLayout((LayoutManager)null);
        this.setTitle("EXPENSIONS");
        JLabel cms = new JLabel("S.NO");
        cms.setFont(new Font("Tahoma", 1, 11));
        cms.setBounds(80, 10, 100, 20);
        this.add(cms);
        JLabel name = new JLabel("DATE");
        name.setFont(new Font("Tahoma", 1, 11));
        name.setBounds(240, 10, 100, 20);
        this.add(name);
        JLabel date = new JLabel("DISCRIPSION");
        date.setFont(new Font("Tahoma", 1, 11));
        date.setBounds(400, 10, 100, 20);
        this.add(date);
        JLabel profess = new JLabel("AMOUNT");
        profess.setFont(new Font("Tahoma", 1, 11));
        profess.setBounds(560, 10, 100, 20);
        this.add(profess);
        this.table = new JTable();
        this.table.setBounds(0, 40, 700, 400);
        this.add(this.table);


        Total_Amount = new JLabel("TOTAL_AMOUNT:");
        Total_Amount.setFont(new Font("Tahoma", 1, 11));
        Total_Amount.setBounds(750, 60, 200, 20);
        this.add(Total_Amount);

        Current_Amount= new JLabel("TOTAL_EXPENSE:");
        Current_Amount.setFont(new Font("Tahoma",1,11));
        Current_Amount.setBounds(750,80,150,20);
        this.add(Current_Amount);

        Balance=new JLabel("REMAINING_AMOUNT:");
        Balance.setFont(new Font("Tahoma",1,11));
        Balance.setBounds(750,100,200,20);
        this.add(Balance);
            try {
            Conn c = new Conn();
            String query3 = "SELECT SUM(AMOUNT) AS sum_value FROM member";
            String query4="SELECT SUM(AMOUNT) AS sum_value1 FROM expension";
            ResultSet rs = c.s.executeQuery("select * from Expension");
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
            ResultSet rs1=c.s.executeQuery(query3);
         if (rs1.next()) {
           TotalA = rs1.getDouble("sum_value");  // Store the sum in amounts variable
           Total_Amount.setText("TOTAL_AMOUNT: " + TotalA);  // Update the label
            } else {
                TotalA = 0.0;  // Set to zero if no sum value found
                Total_Amount.setText("TOTAL_AMOUNT: 0.0");  // Update the label
            }

                ResultSet rs2=c.s.executeQuery(query4);
                if (rs2.next()) {
                    TotalC = rs2.getDouble("sum_value1");  // Store the sum in amounts variable
                    Current_Amount.setText("TOTAL_EXPENSE: " + TotalC);  // Update the label
                } else {
                    TotalC = 0.0;  // Set to zero if no sum value found
                    Current_Amount.setText("TOTAL_EXPENSE: 0.0");  // Update the label
                }

                    Remaining=TotalA-TotalC;
                    Balance.setText("REMAINING_AMOUNT: " + Remaining);  // Update the label



        } catch (Exception var7) {
            var7.printStackTrace();
        }

        this.setBounds(300, 200, 1050, 600);
        this.setVisible(true);
        this.setLocation(250, 100);
    }
    public static void main(String[] arg) {
        new Expenses();
    }
}
