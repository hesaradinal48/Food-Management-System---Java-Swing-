package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit_Account extends JFrame implements ActionListener {
    private JTextField userNameField, passwordField, addressField, phoneField;

    public Edit_Account()
    {
        setTitle("Edit Account");
        setSize(1000, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel userNameLabel = new JLabel("User Name:");
        userNameField = new JTextField();
        JLabel passwordLabel = new JLabel("New Password:");
        passwordField = new JTextField();
        JLabel addressLabel = new JLabel("New Address:");
        addressField = new JTextField();
        JLabel phoneLabel = new JLabel("New Phone:");
        phoneField = new JTextField();

        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneLabel);
        panel.add(phoneField);

        JButton editButton = new JButton("Edit Now");
        editButton.addActionListener(this);
        panel.add(editButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Edit Now")) {
            String userName = userNameField.getText();
            String newPassword = passwordField.getText();
            String newAddress = addressField.getText();
            String newPhone = phoneField.getText();

            try
            {
                Connection connection = DBConnection.getConnection();
                String selectQuery = "SELECT * FROM customer WHERE c_user_name = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, userName);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    String updateQuery = "UPDATE customer SET c_password = ?, c_address = ?, c_phone = ? WHERE c_user_name = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, newPassword);
                    updateStatement.setString(2, newAddress);
                    updateStatement.setString(3, newPhone);
                    updateStatement.setString(4, userName);
                    updateStatement.executeUpdate();
                    updateStatement.close();
                    JOptionPane.showMessageDialog(this, "Account details updated successfully!");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No account found with the provided username.");
                }

                resultSet.close();
                selectStatement.close();
                DBConnection.closeConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while updating account details. Please try again later.");
            }

            userNameField.setText("");
            passwordField.setText("");
            addressField.setText("");
            phoneField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new Edit_Account();
            }
        });
    }
}
