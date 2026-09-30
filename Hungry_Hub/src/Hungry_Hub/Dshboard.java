package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dshboard extends JFrame implements ActionListener {
    private JButton manageMenuButton, feedbackButton, editAccountButton, logoutButton, menuButton,deleteButton;

    public Dshboard()
    {
        setTitle("Hungry Hub - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Hungry Hub Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(titleLabel);

        menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Arial", Font.PLAIN, 24));
        menuButton.addActionListener(this);
        buttonPanel.add(menuButton);

        feedbackButton = new JButton("Feedback");
        feedbackButton.setFont(new Font("Arial", Font.PLAIN, 24));
        feedbackButton.addActionListener(this);
        buttonPanel.add(feedbackButton);

        editAccountButton = new JButton("Edit Account Details");
        editAccountButton.setFont(new Font("Arial", Font.PLAIN, 24));
        editAccountButton.addActionListener(this);
        buttonPanel.add(editAccountButton);

        deleteButton = new JButton("Delete my Account");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 24));
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 24));
        logoutButton.addActionListener(this);
        buttonPanel.add(logoutButton);

        add(buttonPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == feedbackButton) {

            JOptionPane.showMessageDialog(this, "Open feedback page", "Feedback", JOptionPane.INFORMATION_MESSAGE);
            new Feed_back();

        }
        else if (e.getSource() == editAccountButton)
        {
            JOptionPane.showMessageDialog(this, "Open edit account details page", "Edit Account Details", JOptionPane.INFORMATION_MESSAGE);
            new Edit_Account();
            dispose();
        }
        else if (e.getSource() == logoutButton)
        {
            JOptionPane.showMessageDialog(this, "Logging out...", "Logout", JOptionPane.INFORMATION_MESSAGE);
            new Login().setVisible(true);
            dispose();
        }
        else if (e.getSource() == menuButton)
        {

            JOptionPane.showMessageDialog(this, "Open menu page", "Menu", JOptionPane.INFORMATION_MESSAGE);
            new Menu();
            dispose();
        } else if (e.getSource() == deleteButton)
        {
            JOptionPane.showMessageDialog(this, "Open delete page", "Menu", JOptionPane.INFORMATION_MESSAGE);
            new DeleteAccount();
            dispose();
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Dshboard();
            }
        });
    }
}
