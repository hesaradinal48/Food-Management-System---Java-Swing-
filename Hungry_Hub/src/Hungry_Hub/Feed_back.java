package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Feed_back extends JFrame implements ActionListener
{
    private JTextField userNameField;
    private JTextArea feedbackArea;

    public Feed_back()
    {
        setTitle("Feedback Form");
        setSize(1000, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userNameLabel = new JLabel("User Name:");
        userNameField = new JTextField();
        JLabel feedbackLabel = new JLabel("Feedback:");
        feedbackArea = new JTextArea();
        feedbackArea.setLineWrap(true);

        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(feedbackLabel);
        panel.add(new JScrollPane(feedbackArea));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String userName = userNameField.getText();
            String feedback = feedbackArea.getText();

            System.out.println("User Name: " + userName);
            System.out.println("Feedback: " + feedback);

            //insert
            try {
                Connection connection = DBConnection.getConnection();
                String insertQuery = "INSERT INTO feed_back (c_name, feedback) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, feedback);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                DBConnection.closeConnection(connection);
                JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while submitting feedback. Please try again later.");
            }

            userNameField.setText("");
            feedbackArea.setText("");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Feed_back();
            }
        });
    }
}
