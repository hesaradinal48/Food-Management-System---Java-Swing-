package Hungry_Hub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class payment extends JFrame implements ActionListener
{
    private JTextField nameField, bankField, cardNumberField, cvvField;

    public payment()
    {
        setTitle("Payment Form");
        setSize(1000, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel bankLabel = new JLabel("Bank:");
        bankField = new JTextField();
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberField = new JTextField();
        JLabel cvvLabel = new JLabel("CVV:");
        cvvField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(bankLabel);
        panel.add(bankField);
        panel.add(cardNumberLabel);
        panel.add(cardNumberField);
        panel.add(cvvLabel);
        panel.add(cvvField);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(this);
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        panel.add(payButton);
        panel.add(clearButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Pay"))
        {

            String name = nameField.getText();
            String bank = bankField.getText();
            String cardNumber = cardNumberField.getText();
            String cvv = cvvField.getText();


            JOptionPane.showMessageDialog(this, "Payment processed successfully!\nName: " + name + "\nBank: " + bank + "\nCard Number: " + cardNumber + "\nCVV: " + cvv);

            try (Connection conn = DBConnection.getConnection())
            {
                String query = "INSERT INTO payment (c_name, c_bank, c_number, c_cvv) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, bank);
                pstmt.setString(3, cardNumber);
                pstmt.setString(4, cvv);
                pstmt.executeUpdate();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            new End();
            dispose();
        }
        else if (e.getActionCommand().equals("Clear"))
        {

            nameField.setText("");
            bankField.setText("");
            cardNumberField.setText("");
            cvvField.setText("");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new payment();
            }
        });
    }
}
