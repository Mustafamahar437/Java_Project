package MessManagements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class Units extends JFrame implements ActionListener {

    private JTable table;
    static double amounts, amounts1, unitPrice,memberamount,totalUnits12,balanceamount;
    private JTextField t1;
    private JButton searchButton;
    private JLabel up, ca, tamount, name,balance;
    double totalUnits;
    private JLabel totalMemberLabel, totalAmountLabel, currentAmountLabel, remainingLabel, totalUnitsLabel, unitPriceLabel, unitsLabel;
    double totalExpense, totalAmount;

    Units() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("UNITS_INFO");


        JLabel cmsid = new JLabel("Enter your CMS_ID:");
        cmsid.setFont(new Font("Tahoma", Font.BOLD, 11));
        cmsid.setBounds(20, 10, 130, 20);
        add(cmsid);

        JLabel name1 = new JLabel("Name of Member:");
        name1.setFont(new Font("Tahoma", Font.BOLD, 11));
        name1.setBounds(20, 50, 130, 20);
        add(name1);
        name = new JLabel();
        name.setFont(new Font("Tahoma", Font.BOLD, 11));
        name.setBounds(150, 50, 130, 20);
        add(name);

        t1 = new JTextField();
        t1.setBounds(160, 10, 100, 20);
        add(t1);

        JLabel cms = new JLabel("CMS_ID");
        cms.setFont(new Font("Tahoma", Font.BOLD, 11));
        cms.setBounds(20, 100, 100, 20);
        add(cms);

        JLabel cmsname = new JLabel("NAME");
        cmsname.setFont(new Font("Tahoma", Font.BOLD, 11));
        cmsname.setBounds(130, 100, 100, 20);
        add(cmsname);

        JLabel date = new JLabel("DATE");
        date.setFont(new Font("Tahoma", Font.BOLD, 11));
        date.setBounds(230, 100, 100, 20);
        add(date);

        JLabel BF = new JLabel("BREAK_FAST");
        BF.setFont(new Font("Tahoma", Font.BOLD, 11));
        BF.setBounds(320, 100, 100, 20);
        add(BF);

        JLabel lunch = new JLabel("LUNCH");
        lunch.setFont(new Font("Tahoma", Font.BOLD, 11));
        lunch.setBounds(440, 100, 100, 20);
        add(lunch);

        JLabel dinner = new JLabel("DINNER");
        dinner.setFont(new Font("Tahoma", Font.BOLD, 11));
        dinner.setBounds(530, 100, 100, 20);
        add(dinner);

        JLabel unit = new JLabel("TOTAL_UNITS:");
        unit.setFont(new Font("Tahoma", Font.BOLD, 11));
        unit.setBounds(700, 100, 130, 20);
        add(unit);

        up = new JLabel();
        up.setFont(new Font("Tahoma", Font.BOLD, 11));
        up.setBounds(850, 100, 130, 20);
        add(up);

        unitPriceLabel = new JLabel("UNIT_PRICE: N/A");
        unitPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        unitPriceLabel.setBounds(700, 130, 200, 20);
        add(unitPriceLabel);

        tamount = new JLabel("TOTAL_AMOUNT: ");
        tamount.setFont(new Font("Tahoma", Font.BOLD, 11));
        tamount.setBounds(700, 160, 160, 20);
        add(tamount);

        ca = new JLabel("PAID_AMOUNT:");
        ca.setFont(new Font("Tahoma", Font.BOLD, 11));
        ca.setBounds(700, 190, 160, 20);
        add(ca);

        balance = new JLabel("REMAINING_BALANCE:");
        balance.setFont(new Font("Tahoma", Font.BOLD, 11));
        balance.setBounds(700, 220, 200, 20);
        add(balance);

        table = new JTable();
        table.setBounds(0, 130, 600, 400);
        add(table);

        searchButton = new JButton("Search");
        searchButton.setBounds(280, 10, 80, 20);
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.white);
        searchButton.addActionListener(this);
        add(searchButton);

        totalMemberLabel = new JLabel("TOTAL_MEMBER: 0.0");
        totalMemberLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalMemberLabel.setBounds(700, 300, 200, 50);
        add(totalMemberLabel);

        totalAmountLabel = new JLabel("TOTAL_AMOUNT: 0.0");
        totalAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalAmountLabel.setBounds(700, 330, 200, 50);
        add(totalAmountLabel);

        currentAmountLabel = new JLabel("EXPENSED_AMOUNT: 0.0");
        currentAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        currentAmountLabel.setBounds(700, 360, 200, 50);
        add(currentAmountLabel);

        remainingLabel = new JLabel("REMAINING_AMOUNT: 0.0");
        remainingLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        remainingLabel.setBounds(700, 390, 200, 50);
        add(remainingLabel);

        totalUnitsLabel = new JLabel("TOTAL_UNITS:");
        totalUnitsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalUnitsLabel.setBounds(700, 420, 200, 50);
        add(totalUnitsLabel);

        unitsLabel = new JLabel("0");
        unitsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        unitsLabel.setBounds(800, 420, 130, 50);
        add(unitsLabel);



        try {
            Conn c = new Conn();
            String query1 = "SELECT SUM(AMOUNT) AS total_amount FROM member";
            String query2 = "SELECT SUM(AMOUNT) AS total_expense FROM expension";
            String query3 = "SELECT SUM(sumnum) AS total_member FROM allmember";
            String query4 = "SELECT SUM(bf) + SUM(lunch) + SUM(dinner) AS total_units FROM Units";

            ResultSet rs1 = c.s.executeQuery(query1);
            if (rs1.next()) {
                totalAmount = rs1.getDouble("total_amount");
                totalAmountLabel.setText("TOTAL_AMOUNT: " + totalAmount);
            }

            ResultSet rs2 = c.s.executeQuery(query2);
            if (rs2.next()) {
                totalExpense = rs2.getDouble("total_expense");
                currentAmountLabel.setText("EXPENSED_AMOUNT: " + totalExpense);
            }

            ResultSet rs3 = c.s.executeQuery(query3);
            if (rs3.next()) {
                double totalMembers = rs3.getDouble("total_member");
                totalMemberLabel.setText("TOTAL_MEMBER: " + totalMembers);
            }

            ResultSet rs4 = c.s.executeQuery(query4);
            if (rs4.next()) {
                totalUnits = rs4.getInt("total_units");
                unitsLabel.setText(String.valueOf(totalUnits));

                // Calculate unit price and set the label
                if (totalUnits != 0) { // Avoid division by zero
                    unitPrice = totalExpense / totalUnits;
                    unitPriceLabel.setText("UNIT_PRICE: " + unitPrice);
                } else {
                    unitPriceLabel.setText("UNIT_PRICE: N/A"); // Handle division by zero case
                }

            }

            double remainingAmount = totalAmount - totalExpense;
            remainingLabel.setText("REMAINING_AMOUNT: " + remainingAmount);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(300, 200, 1050, 600);
        setVisible(true);
        setLocation(250, 100);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            Conn co = new Conn();
            ResultSet rs = co.s.executeQuery("select * from Units");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (ae.getSource() == searchButton) {
            try {
                String cmsId = t1.getText();
                if (!cmsId.isEmpty()) {
                    String query1 = "SELECT * FROM Units WHERE id='" + cmsId + "'";
                    String query2 = "SELECT id, SUM(bf) + SUM(lunch) + SUM(dinner) AS total_units " + "FROM Units WHERE id='" + cmsId + "' GROUP BY id";
                    String query3 = "SELECT SUM(Amount) AS sum_value FROM member WHERE CMSD='" + cmsId + "'";
                    String query4 = "SELECT NAME  FROM member WHERE CMSD='" + cmsId + "'";
                    Conn co = new Conn();
                    ResultSet sr = co.s.executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(sr));

                    ResultSet rs = co.s.executeQuery(query2);
                    if (rs.next()) {
                        totalUnits12 = rs.getDouble("total_units");
                        up.setText(String.valueOf(totalUnits12));
                    } else {
                        totalUnits = 0.0;  // Set to zero if no matching records found
                        up.setText("0.0");
                    }
                    if (unitPrice != 0) { // Avoid division by zero
                        memberamount = unitPrice* totalUnits12;
                        tamount.setText("TOTAL_AMOUNT: " + memberamount);
                    } else {
                        tamount.setText("TOTAL_AMOUNT: N/A"); // Handle division by zero case
                    }




                    ResultSet rs3 = co.s.executeQuery(query4);
                    if (rs3.next()) {
                        name.setText(rs3.getString("NAME"));
                    }

                    ResultSet sr1 = co.s.executeQuery(query3);
                    if (sr1.next()) {
                        amounts1 = sr1.getDouble("sum_value");
                        ca.setText("PAID_AMOUNT: " + amounts1);
                    } else {
                        amounts1 = 0.0;
                        ca.setText("PAID_AMOUNT: 0.0");
                    }

                    if (memberamount != 0) { // Avoid division by zero
                        balanceamount = amounts1- memberamount;
                        balance.setText("REMAINING_BALANCE: " + balanceamount);
                    } else {
                        balance.setText("REMAINING_BALANCE: N/A"); // Handle division by zero case
                    }


                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a CMS_ID");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error retrieving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] arg) {
        new Units();
    }
}
