package Server;

import java.net.ServerSocket;

// Test
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server has started");
        try {
            while (true) {

                ServerSidePlayer player1
                        = new ServerSidePlayer(listener.accept(), '1');
                ServerSidePlayer player2
                        = new ServerSidePlayer(listener.accept(), '2');
                ServerSideGame game = new ServerSideGame(player1, player2);


                player1.setOpponent(player2);
                player2.setOpponent(player1);
                game.currentPlayer = player1;
                game.start();
            }
        } finally {
            listener.close();
        }
    }
}