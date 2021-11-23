package GUI;

import Server.Player;

import javax.swing.*;
import java.io.PrintWriter;

public class WelcomePanel extends JPanel {
    Player player1;
    Player player2;

    PrintWriter out;
    String responseInput;
    JLabel jLabel = new JLabel("Welcome");

    public WelcomePanel(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        jLabel.setOpaque(true);
        add(jLabel);
    }

}
