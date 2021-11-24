package GUI;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WelcomePanel extends JPanel {
    JLabel jLabel = new JLabel("Welcome");


    public WelcomePanel() {
        this.setVisible(true);
        jLabel.setOpaque(true);
        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));
        jLabel.setText("Waiting for player..");
        add(jLabel);

    }
}
