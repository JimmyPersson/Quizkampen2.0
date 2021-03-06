package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server has started");
        try {
            while (true) {

              Socket socket1
                        = listener.accept();
                System.out.println("Player 1 anslöt");
                Socket socket2
                        = listener.accept();
                System.out.println("Player 2 anslöt");
                GameServer game = new GameServer(socket1, socket2);

                game.start();
            }
        } finally {
            listener.close();
        }
    }
}