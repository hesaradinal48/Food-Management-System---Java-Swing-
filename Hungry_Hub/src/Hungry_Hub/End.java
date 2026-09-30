package Hungry_Hub;

import javax.swing.*;
import java.awt.Font;

public class End {
    public End() {
        JFrame frame = new JFrame("Payment Successful");

        JLabel paymentLabel = new JLabel("Payment Successful!");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel deliveryLabel = new JLabel("Your product will be delivered soon.");
        deliveryLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.add(paymentLabel);
        panel.add(deliveryLabel);

        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new End();
            }
        });
    }
}
