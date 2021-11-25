package Server;

import GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class GameServer extends Thread {
    Properties prop = new Properties();
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
    String playedCat;
    String score = "";
    int roundLimit;
    int roundCounter = 0;

    public GameServer(Socket socket1, Socket socket2) throws IOException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/Server/properties.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        roundLimit = Integer.parseInt(p.getProperty("customRoundLimit", "3"));
        System.out.println(roundLimit);
        this.socket1 = socket1;
        this.socket2 = socket2;

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
            System.out.println("Something went wrong!" + e);
        }

    }

    public void run() {

        test:
        while (true) {
            if (roundCounter == roundLimit) {
                break;
            }
            while (true) {
                try {
                    responseInput = input.readLine();

                    if (responseInput.startsWith("CAT")) {
                        result = responseInput;
                        output.println(result);
                    } else if (responseInput.startsWith("ENDROUND")) {
                        chosenCat = responseInput.substring(8, responseInput.length() - 1);
                        score = score + (responseInput.substring(responseInput.length() - 1));
                        System.out.println("Score p1: " + score);
                        output.println("SCORE" + score);
                        output2.println("CAT" + chosenCat);
                        output.println("WAITING");
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                try {
                    responseInput2 = input2.readLine();


                    if (responseInput2.startsWith("ENDROUND")) {
                        playedCat = chosenCat;
                        score = score + (responseInput2.substring(responseInput2.length() - 1));
                        System.out.println("Score p2: " + score);
                        output2.println("SCORE" + score);
                        output.println("NEXT");
                        output2.println("WAITING");
                        roundCounter++;
                        continue test;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
