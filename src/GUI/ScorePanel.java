package GUI;

import javax.swing.*;

public class ScorePanel extends JPanel {
    JLabel scoreP1 = new JLabel();
    JLabel scoreP2 = new JLabel();
    int scoreR1P1 = 0;
    int scoreR1P2 = 0;


    public ScorePanel(int score1, int score2){

        if(score1 > 0){
            scoreR1P1 = score1;
            scoreP1.setText(""+scoreR1P1);
        }
        if(score2 > 0){
            scoreR1P2 = score1;
            scoreP2.setText(""+scoreR1P2);
        }
      add(scoreP1);
      add(scoreP2);

    }
}
