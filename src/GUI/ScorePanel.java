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
        scoreP14.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP14.setForeground(Color.white);
        scoreP24.setFont(new Font("Arial", Font.BOLD, 48));
        scoreP24.setForeground(Color.white);
        totalscore1.setFont(new Font("Arial", Font.BOLD, 48));
        totalscore1.setForeground(Color.white);
        totalscore2.setFont(new Font("Arial", Font.BOLD, 48));
        totalscore2.setForeground(Color.white);

        player1.setFont(new Font("Arial", Font.BOLD, 48));
        player1.setForeground(Color.white);
        player2.setFont(new Font("Arial", Font.BOLD, 48));
        player2.setForeground(Color.white);

        this.out = out;

        if (score.length() == 1) {
            scoreR1P1 = Integer.parseInt(score);
            scoreP1.setText("" + scoreR1P1);
            total1 = scoreR1P1;
            totalscore1.setText("Total: " + total1);
        } else if (score.length() == 2) {
            scoreR1P2 = Integer.parseInt(score.substring(1));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            total1 = scoreR1P1;
            total2 = scoreR1P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);

        } else if (score.length() == 3) {
            scoreR2P1 = Integer.parseInt(score.substring(2));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            total1 = scoreR1P1 + scoreR2P1;
            total2 = scoreR1P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);
        } else if (score.length() == 4) {
            scoreR2P2 = Integer.parseInt(score.substring(3));
            scoreR2P1 = Integer.parseInt(score.substring(2, 3));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            scoreP22.setText("" + scoreR2P2);
            total1 = scoreR1P1 + scoreR2P1;
            total2 = scoreR1P2 + scoreR2P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);
        } else if (score.length() == 5) {
            scoreR3P1 = Integer.parseInt(score.substring(4));
            scoreR2P2 = Integer.parseInt(score.substring(3, 4));
            scoreR2P1 = Integer.parseInt(score.substring(2, 3));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            scoreP22.setText("" + scoreR2P2);
            scoreP13.setText("" + scoreR3P1);
            total1 = scoreR1P1 + scoreR2P1 + scoreR3P1;
            total2 = scoreR1P2 + scoreR2P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);

        } else if (score.length() == 6) {
            scoreR3P2 = Integer.parseInt(score.substring(5));
            scoreR3P1 = Integer.parseInt(score.substring(4, 5));
            scoreR2P2 = Integer.parseInt(score.substring(3, 4));
            scoreR2P1 = Integer.parseInt(score.substring(2, 3));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            scoreP22.setText("" + scoreR2P2);
            scoreP13.setText("" + scoreR3P1);
            scoreP23.setText("" + scoreR3P2);
            total1 = scoreR1P1 + scoreR2P1 + scoreR3P1;
            total2 = scoreR1P2 + scoreR2P2 + scoreR3P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);
        } else if (score.length() == 7) {
            scoreR4P1 = Integer.parseInt(score.substring(6));
            scoreR3P2 = Integer.parseInt(score.substring(5, 6));
            scoreR3P1 = Integer.parseInt(score.substring(4, 5));
            scoreR2P2 = Integer.parseInt(score.substring(3, 4));
            scoreR2P1 = Integer.parseInt(score.substring(2, 3));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            scoreP22.setText("" + scoreR2P2);
            scoreP13.setText("" + scoreR3P1);
            scoreP23.setText("" + scoreR3P2);
            scoreP14.setText("" + scoreR4P1);
            total1 = scoreR1P1 + scoreR2P1 + scoreR3P1 + scoreR4P1;
            total2 = scoreR1P2 + scoreR2P2 + scoreR3P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);
        } else if (score.length() == 8) {
            scoreR4P2 = Integer.parseInt(score.substring(7));
            scoreR4P1 = Integer.parseInt(score.substring(6, 7));
            scoreR3P2 = Integer.parseInt(score.substring(5, 6));
            scoreR3P1 = Integer.parseInt(score.substring(4, 5));
            scoreR2P2 = Integer.parseInt(score.substring(3, 4));
            scoreR2P1 = Integer.parseInt(score.substring(2, 3));
            scoreR1P2 = Integer.parseInt(score.substring(1, 2));
            scoreR1P1 = Integer.parseInt(score.substring(0, 1));
            scoreP1.setText("" + scoreR1P1);
            scoreP2.setText("" + scoreR1P2);
            scoreP12.setText("" + scoreR2P1);
            scoreP22.setText("" + scoreR2P2);
            scoreP13.setText("" + scoreR3P1);
            scoreP23.setText("" + scoreR3P2);
            scoreP14.setText("" + scoreR4P1);
            scoreP24.setText("" + scoreR4P2);
            total1 = scoreR1P1 + scoreR2P1 + scoreR3P1 + scoreR4P1;
            total2 = scoreR1P2 + scoreR2P2 + scoreR3P2 + scoreR4P2;
            totalscore1.setText("Total: " + total1);
            totalscore2.setText("Total: " + total2);
        }

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

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 4;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP14, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 4;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scoreP24, gbc);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(totalscore1, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(totalscore2, gbc);
    }
}
