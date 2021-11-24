package Server;

import GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameServer implements Runnable {

    Socket socket1;
    Socket socket2;
    String responseInput;
    BufferedReader input;
    PrintWriter output;
    BufferedReader input2;
    PrintWriter output2;
    String result;
    JLabel jLabel = new JLabel("Welcome");
    int score1 = 0;
    int score2;


    public GameServer(Socket socket1, Socket socket2) throws IOException {

        this.socket1 = socket1;
        this.socket2 = socket2;
        System.out.println(socket1);

        try {
            input = new BufferedReader(
                    new InputStreamReader(socket1.getInputStream()));
            output = new PrintWriter(socket1.getOutputStream(), true);
            input2 = new BufferedReader(
                    new InputStreamReader(socket2.getInputStream()));
            output2 = new PrintWriter(socket2.getOutputStream(), true);

            output.println("GAMETIME");
            output2.println("WAITING");

        } catch (IOException e) {
            System.out.println("Player died: " + e);
        }

    }
    public void run() {

        while (true) {
            try {
                responseInput = input.readLine();
                if (responseInput.startsWith("CAT")) {
                    result = responseInput;
                    output.println(result);
                } else if (responseInput.startsWith("ENDROUND")) {
                    score1 = Integer.parseInt(responseInput.substring(8));
                    System.out.println(score1);
                    System.out.println("test2");
                    output2.println("ROUND");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}