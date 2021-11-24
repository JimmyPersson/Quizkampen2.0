package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    PrintWriter out;
    BufferedReader br;
    String category;
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
    private ArrayList<String> questionList = new ArrayList();
    private int score = 0;


    public GamePanel(String responseInput, PrintWriter out) throws IOException {
        this.out = out;

        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));

        br = new BufferedReader(new FileReader("src/Server/Database.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
        category = responseInput.substring(3);
        System.out.println(category);
        for (String line = br.readLine(); line != null; line = br.readLine()) {

        if (line.startsWith(category)) {
            for (int i = 0; i < 20; i++) {
                questionList.add(br.readLine());
            }
        }
        }

        Question = questionList.get(0);
        Answer1 = questionList.get(1);
        Answer2 = questionList.get(2);
        Answer3 = questionList.get(3);
        Answer4 = questionList.get(4);
        CorrectAnswer = Answer1;

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

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == jb1) {
            if (jb1.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta till servern");
                score++;
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb2) {
            if (jb2.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
                score++;
            } else {
                    System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb3) {
            if (jb3.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
                score++;
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb4) {
            if (jb4.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
                score++;
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }}}