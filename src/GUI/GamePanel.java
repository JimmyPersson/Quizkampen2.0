package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    PrintWriter out;
    String responseInput;
    JLabel jl1 = new JLabel();
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();

    private String Question;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String Answer4;
    private String CorrectAnswer;


    public GamePanel(String responseInput, PrintWriter out) {
        this.out = out;
        this.responseInput = responseInput;
        getStringsFromRegex(responseInput);

        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));


        jl1.setText(Question);
        add(jl1);

        jb1.setText(Answer1);
        jb1.addActionListener(this);
        add(jb1);

        jb2.setText(Answer2);
        jb2.addActionListener(this);
        add(jb2);

        jb3.setText(Answer3);
        jb3.addActionListener(this);
        add(jb3);

        jb4.setText(Answer4);
        jb4.addActionListener(this);
        add(jb4);

    }


    public void getStringsFromRegex(String responseInput) {
        String[] temp = responseInput.split("--");
        Question = temp[0];
        Answer1 = temp[1];
        Answer2 = temp[2];
        Answer3 = temp[3];
        Answer4 = temp[4];
        CorrectAnswer = temp[4];
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == jb1) {
            if (jb1.getText().equals(CorrectAnswer)) {
                out.println("Då är det rätt och vi skickar detta tillservern");
            } else {
                out.println("Då är deeeeeeet feeeeeel");
            }


            if (e.getSource() == jb2) {
                if (jb2.getText().equals(CorrectAnswer)) {
                    out.println("Då är det rätt och vi skickar detta tillservern");
                } else {
                    out.println("Då är deeeeeeet feeeeeel");
                }


            }

        }
    }

}