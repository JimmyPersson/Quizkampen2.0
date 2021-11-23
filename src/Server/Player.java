package Server;

import GUI.WelcomePanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
    String playerName;
    Player opponent;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    WelcomePanel welcomePanel;

    public Player(Socket socket, String playerName, WelcomePanel welcomePanel) {
        this.socket = socket;
        this.playerName = playerName;
        this.welcomePanel = welcomePanel;
        try {
            input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("WELCOME " + playerName);
            output.println("MESSAGE Waiting for opponent to connect");
        } catch (IOException e) {
            System.out.println("Player died: " + e);
        }
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void run() {
        try {

            output.println("MESSAGE All players connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
