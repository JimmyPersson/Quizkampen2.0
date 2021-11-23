package GUI;

import Server.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WelcomePanel extends JPanel implements Runnable {
    Player player1;
    Player player2;
    Socket socket = new Socket("127.0.0.1", 8901);
    String responseInput;
    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
    JLabel jLabel = new JLabel("Welcome");


    public WelcomePanel(Socket socket, Player player1, Player player2) throws IOException {

        this.player1 = player1;
        this.player2 = player2;
        jLabel.setOpaque(true);
        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));
        jLabel.setText("test");
        add(jLabel);

    }
    public void run() {

            try {
                GamePanel game = new GamePanel(responseInput, output);
                System.out.println("test2");
                //output.println("MESSAGE All players connected");
                System.out.println("kött");

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
