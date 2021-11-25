package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

public class ScorePanel extends JPanel {
    PrintWriter out;
    JLabel scoreP1 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP2 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP12 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP22 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP13 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP23 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP14 = new JLabel("", SwingConstants.CENTER);
    JLabel scoreP24 = new JLabel("", SwingConstants.CENTER);
    JLabel totalscore1 = new JLabel("", SwingConstants.CENTER);
    JLabel totalscore2 = new JLabel("", SwingConstants.CENTER);
    JLabel player1 = new JLabel("Player 1", SwingConstants.CENTER);
    JLabel player2 = new JLabel("Player 2", SwingConstants.CENTER);
    int scoreR1P1 = 0;
    int scoreR2P1 = 0;
    int scoreR3P1 = 0;
    int scoreR1P2 = 0;
    int scoreR2P2 = 0;
    int scoreR3P2 = 0;
    int scoreR4P1 = 0;
    int scoreR4P2 = 0;
    int total1 = 0;
    int total2 = 0;
    String score;

    public ScorePanel(PrintWriter out, String score) {
        this.score = score;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        scoreP1.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP1.setForeground(Color.white);
        scoreP2.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP2.setForeground(Color.white);
        scoreP12.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP12.setForeground(Color.white);
        scoreP22.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP22.setForeground(Color.white);
        scoreP13.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP13.setForeground(Color.white);
        scoreP23.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP23.setForeground(Color.white);

        player1.setFont(new Font("Arial", Font.BOLD, 48));
        player1.setForeground(Color.white);
        player2.setFont(new Font("Arial", Font.BOLD, 48));
        player2.setForeground(Color.white);

        this.out = out;

            if(score.length() == 1){
                System.out.println("Score lenght1 "+ score.length());
                scoreR1P1 = Integer.parseInt(score);
                scoreP1.setText(""+scoreR1P1);
                System.out.println(scoreR1P1);
            }
            else if (score.length() == 2){
                System.out.println("Score lenght "+ score.length());
                scoreR1P2 = Integer.parseInt(score.substring(1));
                scoreR1P1 = Integer.parseInt(score.substring(0));
             /*   scoreP1 =
                scoreP2.setText(""+scoreR1P2); */
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 3){
                System.out.println("Score lenght "+ score.length());
                scoreR2P1 = Integer.parseInt(score.substring(2));
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 4){
                System.out.println("Score lenght "+ score.length());
                scoreR2P2 = Integer.parseInt(score.substring(3));
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 5){
                System.out.println("Score lenght "+ score.length());
                scoreR3P1 = Integer.parseInt(score.substring(4));
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 6){
                System.out.println("Score lenght "+ score.length());
                scoreR3P2 = Integer.parseInt(score.substring(5));
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 7){
                System.out.println("Score lenght "+ score.length());
                scoreR4P1 = Integer.parseInt(score.substring(6));
                System.out.println(scoreR1P2);
            }
            else if (score.length() == 8){
                System.out.println("Score lenght "+ score.length());
                scoreR4P2 = Integer.parseInt(score.substring(7));
                System.out.println(scoreR1P2);
            }


        total1 = scoreR1P1 + scoreR1P1 + scoreR3P1;
        totalscore1.setText("" + total1);
        total2 = scoreR1P2 + scoreR1P2 + scoreR3P2;
        totalscore2.setText("" + total2);

        setBackground(new Color(30, 120, 200));

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(player1, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(player2, gbc);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP1, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP2, gbc);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP12, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP22, gbc);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP13, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP23, gbc);


    }
}
