package Server;

import GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClass implements Runnable {

    Socket socket1;
    Socket socket2;
    String responseInput;
    BufferedReader input;
    PrintWriter output;
    BufferedReader input2;
    PrintWriter output2;
    JLabel jLabel = new JLabel("Welcome");


    public GameClass(Socket socket1, Socket socket2) throws IOException {

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

            output.println("WELCOME ");
            output2.println("WELCOME ");

            output.println("MESSAGE Waiting for opponent to connect");

        } catch (IOException e) {
            System.out.println("Player died: " + e);
        }

    }
    public void run() {

        try {
    //      GamePanel game = new GamePanel(responseInput, output);
            System.out.println("test2");
            //output.println("MESSAGE All players connected");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}