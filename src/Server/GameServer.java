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
    String responseInput2;
    BufferedReader input;
    PrintWriter output;
    BufferedReader input2;
    PrintWriter output2;
    String result;
    JLabel jLabel = new JLabel("Welcome");
    String chosenCat;
    int score1 = 0;
    int score2 = 0;


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
                    chosenCat = responseInput.substring(8, responseInput.length() - 1);
                    score1 = Integer.parseInt(responseInput.substring(responseInput.length() - 1));
                    System.out.println(score1);
                    System.out.println("test2");
                    output.println("SCORE"+score1+score2);
                    output2.println("CAT" + chosenCat);
                    break;
                }


                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                responseInput = input2.readLine();
                if (responseInput.startsWith("CAT")) {
                    result = responseInput;
                    output2.println(result);
                } else if (responseInput.startsWith("ENDROUND")) {
                    chosenCat = responseInput.substring(8, responseInput.length() - 1);
                    score2 = Integer.parseInt(responseInput.substring(responseInput.length() - 1));
                    System.out.println(score2);
                    System.out.println("test2");
                    output2.println("SCORE"+score1+score2);
                }
            } catch (Exception e) {
                e.printStackTrace();
        }}}}