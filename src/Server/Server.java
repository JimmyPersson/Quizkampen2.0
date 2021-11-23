package Server;

import GUI.WelcomePanel;

import java.net.ServerSocket;

// Test
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server has started");
        try {
            while (true) {

              Player player1
                        = new Player(listener.accept(), "1", null );
                Player player2
                        = new Player(listener.accept(), "2", null );
                WelcomePanel wp = new WelcomePanel(player1, player2);


                player1.setOpponent(player2);
                player2.setOpponent(player1);
               // wp.currentPlayer = player1;
                player1.start();
            }
        } finally {
            listener.close();
        }
    }
}