package GUI;

import Server.Player;
import Server.ServerLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WelcomePanel extends JPanel implements ActionListener {
    ServerLogic categories = new ServerLogic(null);
    JLabel jLabel = new JLabel("Welcome to Quizkampen! Choose a category:", SwingConstants.CENTER);
    JButton jButton = new JButton();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    String choice;
    PrintWriter out;

    public WelcomePanel(PrintWriter out) throws IOException {
        this.setBackground(new Color(30, 120, 200));
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400, 400));
        this.out = out;

        GridBagConstraints gbc = new GridBagConstraints();
        jLabel.setPreferredSize(new Dimension(400, 100));
        jLabel.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel.setForeground(Color.white);

        jButton.setFont(new Font("Arial", Font.BOLD, 16));
        jButton.setText("" + categories.CategoryGetter().get(0));
        jButton.addActionListener(this);

        jButton1.setFont(new Font("Arial", Font.BOLD, 16));
        jButton1.setText("" + categories.CategoryGetter().get(1));
        jButton1.addActionListener(this);

        jButton2.setFont(new Font("Arial", Font.BOLD, 16));
        jButton2.setText("" + categories.CategoryGetter().get(2));
        jButton2.addActionListener(this);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jButton, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jButton1, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jButton2, gbc);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            choice = ("CAT" + jButton.getText());
            out.println(choice);
        } else if (e.getSource() == jButton1) {
            choice = ("CAT" + jButton1.getText());
            out.println(choice);
        } else if (e.getSource() == jButton2) {
            choice = ("CAT" + jButton2.getText());
            out.println(choice);
        }
    }
}

