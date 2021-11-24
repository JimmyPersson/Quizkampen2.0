package Client;

import GUI.GamePanel;
import GUI.WelcomePanel;
import Server.Player;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Client extends JFrame {

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String serverAddress) throws Exception {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(true);
        this.setTitle("Waiting for player..");

        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }

   public void play() throws Exception {

       String response;
       try {
           response = in.readLine();
           System.out.println(response);
           if (response.startsWith("GAMETIME")) {
               setTitle("Welcome to Quizkämperz, choose your adväntjur!");
               WelcomePanel welcome = new WelcomePanel();
               add(welcome);
           }

           /* while (true) {
                response = in.readLine();
                if (response.startsWith("<CATEGORY>")) {
                    this.removeAll();
                    //kalla på categorypanel
                    this.revalidate();
                    this.repaint();
                }
                } else if (response.startsWith("")) {
                    int loc = Integer.parseInt(response.substring(15));
                    board[loc].setText(String.valueOf(opponentMark));
                    board[loc].repaint();
                    messageLabel.setText("Opponent moved, your turn");
                } else if (response.startsWith("VICTORY")) {
                    messageLabel.setText("You win");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    messageLabel.setText("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    messageLabel.setText("You tied");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    messageLabel.setText(response.substring(8));
                }
            }
            out.println("QUIT");
        }
        finally {
            socket.close();
        }
    }*/

    /*private boolean wantsToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(frame,
                "Want to play again?",
                "Tic Tac Toe is Fun Fun Fun",
                JOptionPane.YES_NO_OPTION);
        frame.dispose();
        return response == JOptionPane.YES_OPTION;
    }
*/
       } catch (IOException e) {
           e.printStackTrace();
       }}

           public static void main (String[]args) throws Exception {

               String serverAddress = (args.length == 0) ? "localhost" : args[1];
               Client cl = new Client(serverAddress);
               cl.play();


           }
       }
