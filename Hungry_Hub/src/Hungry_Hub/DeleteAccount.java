package Hungry_Hub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccount extends JFrame implements ActionListener {
    private JTextField userNameField;

    public DeleteAccount() {
        setTitle("Delete Account");
        setSize(1000, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel userNameLabel = new JLabel("User Name:");
        userNameField = new JTextField();

        panel.add(userNameLabel);
        panel.add(userNameField);

        JButton deleteButton = new JButton("Delete Now");
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Delete Now")) {
            String userName = userNameField.getText();

            try {
                Connection connection = DBConnection.getConnection();
                String deleteQuery = "DELETE FROM customer WHERE c_user_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setString(1, userName);
                int rowsAffected = preparedStatement.executeUpdate();
                preparedStatement.close();
                DBConnection.closeConnection(connection);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Account deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No account found with the provided username.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while deleting account. Please try again later.");
            }

            userNameField.setText("");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DeleteAccount();
            }
        });
    }
}
