package Server;

import GUI.WelcomePanel;

import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server has started");
        try {
            while (true) {

              Player player1
                        = new Player(listener.accept(), "1", null );
                System.out.println("Player 1 anslöt");
                Player player2
                        = new Player(listener.accept(), "2", null );
                System.out.println("Player 2 anslöt");
                WelcomePanel wp = new WelcomePanel(player1.getSocket(),player1, player2);

                player1.setOpponent(player2);
                player2.setOpponent(player1);
                wp.run();
            }
        } finally {
            listener.close();
        }
    }
}