package MessManagements;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MessManager extends JFrame {
    private JLabel totalMemberLabel, totalAmountLabel, currentAmountLabel, remainingLabel, totalUnitsLabel, unitPriceLabel, unitsLabel;
    static double totalExpense,totalAmount,unitPrice;
    double totalUnits;
    public MessManager() {
        setSize(1000, 600);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mess Manager");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);

        JLabel hostelLabel = new JLabel("Sukkur IBA Hostel NO: 1:");
        hostelLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        hostelLabel.setBounds(300, 30, 300, 50);
        panel.add(hostelLabel);

        JLabel nameLabel = new JLabel("MESS MANAGER :");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        nameLabel.setBounds(30, 80, 100, 50);
        panel.add(nameLabel);

        JLabel emailLabel = new JLabel("EMAIL :");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        emailLabel.setBounds(30, 100, 100, 50);
        panel.add(emailLabel);

        totalMemberLabel = new JLabel("TOTAL_MEMBER: 0.0");
        totalMemberLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalMemberLabel.setBounds(700, 80, 200, 50);
        panel.add(totalMemberLabel);

        totalAmountLabel = new JLabel("TOTAL_AMOUNT: 0.0");
        totalAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalAmountLabel.setBounds(700, 100, 200, 50);
        panel.add(totalAmountLabel);

        currentAmountLabel = new JLabel("EXPENSED_AMOUNT: 0.0");
        currentAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        currentAmountLabel.setBounds(700, 120, 200, 50);
        panel.add(currentAmountLabel);

        remainingLabel = new JLabel("REMAINING_AMOUNT: 0.0");
        remainingLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        remainingLabel.setBounds(700, 140, 200, 50);
        panel.add(remainingLabel);

        totalUnitsLabel = new JLabel("TOTAL_UNITS:");
        totalUnitsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        totalUnitsLabel.setBounds(700, 160, 200, 50);
        panel.add(totalUnitsLabel);

        unitsLabel = new JLabel("0");
        unitsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        unitsLabel.setBounds(800, 160, 130, 50);
        panel.add(unitsLabel);

        unitPriceLabel = new JLabel("UNIT_PRICE: N/A");
        unitPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        unitPriceLabel.setBounds(700, 180, 200, 50);
        panel.add(unitPriceLabel);


        setVisible(true);

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
    }

    public static void main(String[] args) {
        new MessManager();
    }
}
