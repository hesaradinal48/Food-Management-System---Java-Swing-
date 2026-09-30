package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends JFrame implements ActionListener
{
    private JTextField usernameField, phoneField;
    private JPasswordField passwordField;
    private JTextArea addressArea;
    private JButton signUpButton, clearButton;

    public Register()
    {
        setTitle("Hungry Hub - Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(20, 20, 40, 20);
        panel.add(titleLabel, gridBagConstraints);

        JLabel usernameLabel = new JLabel("Username:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(0, 20, 20, 20);
        panel.add(usernameLabel, gridBagConstraints);

        usernameField = new JTextField(30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(usernameField, gridBagConstraints);

        JLabel passwordLabel = new JLabel("Password:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(passwordLabel, gridBagConstraints);

        passwordField = new JPasswordField(30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(passwordField, gridBagConstraints);

        JLabel phoneLabel = new JLabel("Phone:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panel.add(phoneLabel, gridBagConstraints);

        phoneField = new JTextField(30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panel.add(phoneField, gridBagConstraints);

        JLabel addressLabel = new JLabel("Address:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        panel.add(addressLabel, gridBagConstraints);

        addressArea = new JTextArea(6, 30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        panel.add(new JScrollPane(addressArea), gridBagConstraints);

        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(30, 20, 20, 20);
        panel.add(signUpButton, gridBagConstraints);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(30, 20, 20, 20);
        panel.add(clearButton, gridBagConstraints);

        add(panel);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == signUpButton)
        {
            try
            {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String phone = phoneField.getText();
                String address = addressArea.getText();

                // Insert customer data into the database
                try (Connection conn = DBConnection.getConnection()) {
                    String query = "INSERT INTO customer (c_user_name, c_password, c_address, c_phone) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setString(1, username);
                        pstmt.setString(2, password);
                        pstmt.setString(3, address);
                        pstmt.setString(4, phone);
                        pstmt.executeUpdate();
                    }
                }

                // Display registration successful message
                String message = "Username: " + username + "\nPassword: " + password + "\nPhone: " + phone + "\nAddress: " + address;
                JOptionPane.showMessageDialog(this, message, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                new Dshboard();
                dispose();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == clearButton)
        {
            clearFields();
        }
    }

    private void clearFields()
    {
        usernameField.setText("");
        passwordField.setText("");
        phoneField.setText("");
        addressArea.setText("");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Register().setVisible(true);
            }
        });
    }
}

