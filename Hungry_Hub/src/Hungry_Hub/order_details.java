package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class order_details extends JFrame implements ActionListener
{
    private JTextField productNameField, nameField, addressField, phoneNumberField;

    public order_details()
    {
        setTitle("Order Details");
        setSize(1000, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));


        JLabel productNameLabel = new JLabel("Product Name:");
        productNameField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();

        panel.add(productNameLabel);
        panel.add(productNameField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);

        // Buttons for actions
        JButton payNowButton = new JButton("Pay Now");
        payNowButton.addActionListener(this);
        JButton cashOnDeliveryButton = new JButton("Cash on Delivery");
        cashOnDeliveryButton.addActionListener(this);

        panel.add(payNowButton);
        panel.add(cashOnDeliveryButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Pay Now") || e.getActionCommand().equals("Cash on Delivery"))
        {
            String productName = productNameField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phoneNumber = phoneNumberField.getText();

            if (e.getActionCommand().equals("Pay Now"))
            {
                payNow(productName, name, address, phoneNumber);
            }
            else
            {
                cashOnDelivery(productName, name, address, phoneNumber);
            }
        }
    }

    private void payNow(String productName, String name, String address, String phoneNumber)
    {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO order_details (p_name, cu_user_name, cu_address, cu_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, productName);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



        JOptionPane.showMessageDialog(this, "Order placed successfully!\nProduct Name: " + productName + "\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber);
        new payment();
    }

    private void cashOnDelivery(String productName, String name, String address, String phoneNumber)
    {
        try (Connection conn = DBConnection.getConnection())
        {
            String query = "INSERT INTO order_details (p_name, cu_user_name, cu_address, cu_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, productName);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Order placed for Cash on Delivery!\nProduct Name: " + productName + "\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber);
        new End();
        dispose();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new order_details();
            }
        });
    }
}
