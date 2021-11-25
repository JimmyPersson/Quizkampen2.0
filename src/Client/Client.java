package Client;

import GUI.GamePanel;
import GUI.ScorePanel;
import GUI.WelcomePanel;
import Server.Player;
import Server.ServerLogic;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;


public class Client extends JFrame {

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String response;
    private String score;
    private String playedCat = null;


    public Client(String serverAddress) throws Exception {
        this.score = "";
        JLabel jLabel = new JLabel("Waiting for player..", SwingConstants.CENTER);
        jLabel.setBackground(new Color(30, 120, 200));
        this.setBackground(new Color(30, 120, 200));
        jLabel.setOpaque(true);
        this.add(jLabel);
        jLabel.setFont(new Font("Arial", Font.BOLD, 48));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 650);
        this.setResizable(true);
        this.setTitle("Waiting for player..");


        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }

   public void play() {

       while (true){
       try {
           response = in.readLine();

           if (response.startsWith("GAMETIME")) {
               setTitle("Welcome to Quizkampen, all players are connected!");
               getContentPane().removeAll();
               WelcomePanel welcome = new WelcomePanel(out);
               ServerLogic category = new ServerLogic(playedCat);
               add(welcome);
               revalidate();
               repaint();
           }
           else if (response.startsWith("WAITING")) {
               getContentPane().removeAll();
               setTitle("Waiting for opponent to play his/her round");
               revalidate();
           }
           else if (response.startsWith("CAT")){
               getContentPane().removeAll();
               GamePanel gamePanel = new GamePanel(out, response);
               setTitle("Time to play!");
               add(gamePanel);
               revalidate();
           }
           else if (response.startsWith("SCORE")){
               getContentPane().removeAll();
               score = (response.substring(5));
               ScorePanel scorepan = new ScorePanel(out, score);
               add(scorepan);
               revalidate();
               Thread.sleep(2000);
           }
           else if (response.startsWith("NEXT")) {
               getContentPane().removeAll();
               WelcomePanel welcome = new WelcomePanel(out);
               ServerLogic category = new ServerLogic(playedCat);
               add(welcome);
               revalidate();
               repaint();
           }
           else if (response.startsWith("ROUNDSCORE")){
               getContentPane().removeAll();
               score = (response.substring(10));
               ScorePanel scorepan = new ScorePanel(out, score);
               setLayout(new GridLayout(1,1));
               add(scorepan);
               revalidate();
               Thread.sleep(2000);
           }


       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }}}

           public static void main (String[]args) throws Exception {

               String serverAddress = (args.length == 0) ? "localhost" : args[1];
               Client cl = new Client(serverAddress);
               cl.play();


           }
       }
