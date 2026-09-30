package Hungry_Hub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JPanel productsPanel;
    private JButton button1, button2, button3, button4;

    public Menu() {
        setTitle("Product Menu Page");
        setSize(1000, 600);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Available 4 Products.");

        menuItem1 = new JMenuItem("Product 1");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("Product 2");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        menuItem3 = new JMenuItem("Product 3");
        menuItem3.addActionListener(this);
        menu.add(menuItem3);

        menuBar.add(menu);
        setJMenuBar(menuBar);


        productsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        addProductBox("Buger", "Rs. 980", "b.JFIF ");
        addProductBox("Donats", "Rs. 600", "d.JFIF ");
        addProductBox("Pizza", "Rs. 1350", "pi.JFIF ");
        addProductBox("Pasty", "Rs. 700", "pa.JFIF ");

        add(productsPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        button1 = new JButton("Buy Buger");
        button1.addActionListener(this);
        buttonPanel.add(button1);

        button2 = new JButton("Buy Donats");
        button2.addActionListener(this);
        buttonPanel.add(button2);

        button3 = new JButton("Buy Pizza");
        button3.addActionListener(this);
        buttonPanel.add(button3);

        button4 = new JButton("Buy Pasty");
        button4.addActionListener(this);
        buttonPanel.add(button4);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addProductBox(String productName,String price, String imagePath) {
        JPanel productBox = new JPanel(new BorderLayout());
        productBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));


        JLabel priceLabel = new JLabel(price);

        productBox.add(nameLabel, BorderLayout.NORTH);
        productBox.add(priceLabel, BorderLayout.SOUTH);

        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        productBox.add(imageLabel, BorderLayout.WEST);

        productsPanel.add(productBox);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1)
        {
            JOptionPane.showMessageDialog(this, "Are you Ok?");
        }
        else if (e.getSource() == button2)
        {
            JOptionPane.showMessageDialog(this, "Are you Ok?");
        }
        else if (e.getSource() == button3)
        {
            JOptionPane.showMessageDialog(this, "Are you Ok?");
        }
        else if (e.getSource() == button4)
        {
            JOptionPane.showMessageDialog(this, "Are you Ok?");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Menu();
            }
        });
    }
}
