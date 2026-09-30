package Hungry_Hub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
    private JButton loginButton, registerButton, exitButton;

    public Home()
    {
        setTitle("Hungry Hub");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Welcome to Hungry Hub");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.addActionListener(this);
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerButton.addActionListener(this);
        panel.add(registerButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.addActionListener(this);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == loginButton)
        {

            new Login().setVisible(true);
            dispose();
        }
        else if (e.getSource() == registerButton)
        {
            new Register().setVisible(true);
            dispose();
        }
        else if (e.getSource() == exitButton)
        {
            JOptionPane.showMessageDialog(this, "Are you sure ?");
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Home();
            }
        });
    }
}
