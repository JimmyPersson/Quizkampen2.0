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
    JLabel totalscore1 = new JLabel("", SwingConstants.CENTER);
    JLabel totalscore2 = new JLabel("", SwingConstants.CENTER);
    JLabel player1 = new JLabel("Player 1", SwingConstants.CENTER);
    JLabel player2 = new JLabel("Player 2", SwingConstants.CENTER);
    int round = 0;
    int scoreR1P1 = 0;
    int scoreR2P1 = 0;
    int scoreR3P1 = 0;
    int scoreR1P2 = 0;
    int scoreR2P2 = 0;
    int scoreR3P2 = 0;
    int total1;
    int total2;

    public ScorePanel(PrintWriter out, int score1, int score2) {
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

        if (round == 0) {
            scoreR1P1 = score1;
            scoreP1.setText("" + scoreR1P1);
            round++;
            out.println("NEXT");
        }
        if (round == 1) {
            scoreR1P2 = score2;
            scoreP2.setText("" + scoreR1P2);
            round++;
            System.out.println("3a");
            out.println("NEXT");
        }
        if (round == 2) {
            scoreR2P1 = score1;
            scoreP12.setText("" + scoreR2P1);
            round++;
            System.out.println("3b");
            out.println("NEXT");
        }
        if (round == 3) {
            scoreR2P2 = score2;
            scoreP22.setText("" + scoreR2P2);
            round++;
        }
        if (round == 4) {
            scoreR3P1 = score1;
            scoreP13.setText("" + scoreR3P1);
            round++;
        }
        if (round == 5) {
            scoreR3P2 = score2;
            scoreP23.setText("" + scoreR3P2);
            round++;
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
