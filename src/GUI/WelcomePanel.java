package GUI;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WelcomePanel extends JPanel {
    JLabel jLabel = new JLabel("Welcome");
    JButton jButton = new JButton("text1");
    JButton jButton1 = new JButton("text");


    public WelcomePanel() {
        this.setVisible(true);
        jLabel.setOpaque(true);
        setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(6, 1));
        jLabel.setText("Welcome to Quizkampen! Choose a category:");
        add(jLabel);
        add(jButton);
        add(jButton1);
    }
}
