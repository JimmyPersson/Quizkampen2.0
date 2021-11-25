package GUI;

import javax.swing.*;
import java.io.PrintWriter;

public class ScorePanel extends JPanel {
    PrintWriter out;
    JLabel scoreP1 = new JLabel();
    JLabel scoreP2 = new JLabel();
    JLabel scoreP12 = new JLabel();
    JLabel scoreP22 = new JLabel();
    JLabel scoreP13 = new JLabel();
    JLabel scoreP23 = new JLabel();
    JLabel totalscore1 = new JLabel();
    JLabel totalscore2 = new JLabel();
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

        add(scoreP1);
        add(scoreP2);
        add(scoreP12);
        add(scoreP22);
        add(scoreP13);
        add(scoreP23);


    }
}
