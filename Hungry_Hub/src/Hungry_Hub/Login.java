package Hungry_Hub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton, clearButton;

    public Login()
    {
        setTitle("Hungry Hub - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Hungry Hub");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(20, 20, 30, 20);
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
        gridBagConstraints.gridwidth = 2;
        panel.add(usernameField, gridBagConstraints);

        JLabel passwordLabel = new JLabel("Password:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(passwordLabel, gridBagConstraints);

        passwordField = new JPasswordField(30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        panel.add(passwordField, gridBagConstraints);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(30, 20, 20, 20);
        panel.add(loginButton, gridBagConstraints);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(30, 20, 20, 20);
        panel.add(registerButton, gridBagConstraints);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(30, 20, 20, 20);
        panel.add(clearButton, gridBagConstraints);

        add(panel);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == loginButton)
        {
            new Dshboard();
            dispose();
            JOptionPane.showMessageDialog(this, "Login Successful!");
        }
        else if (e.getSource() == registerButton)
        {
            new Register().setVisible(true);
        }
        else if (e.getSource() == clearButton)
        {
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Login().setVisible(true);
            }
        });
    }
}
