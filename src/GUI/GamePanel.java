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


    public GamePanel(String responseInput, PrintWriter out) throws IOException {
        this.out = out;

        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));

        br = new BufferedReader(new FileReader("src/Server/Database.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
        category = responseInput.substring(3);
        if (br.readLine().startsWith(category)) {
            System.out.println(category);
            System.out.println(Question);
            System.out.println(Answer1);
            Question = (br.readLine());
            Answer1 = (br.readLine());
            Answer2 = (br.readLine());
            Answer3 = (br.readLine());
            Answer4 = (br.readLine());
            CorrectAnswer = Answer1;
        }
        }

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


   /* public void setQuestion(String responseInput) throws IOException {
        br = new BufferedReader(new FileReader("C:\\Users\\jimmy\\IdeaProjects\\Quizkampen2.0\\src\\Server\\Database.txt"));
        category = responseInput.substring(3);
        if (br.readLine().startsWith(category)){
            System.out.println(category);
            System.out.println(Question);
            System.out.println(Answer1);
            Question = (br.readLine());
            Answer1 = (br.readLine());
            Answer2 = (br.readLine());
            Answer3 = (br.readLine());
            Answer4 = (br.readLine());
            CorrectAnswer = Answer1;
        }
    */



    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == jb1) {
            if (jb1.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta till servern");
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb2) {
            if (jb2.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
            } else {
                    System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb3) {
            if (jb3.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }
        if (e.getSource() == jb4) {
            if (jb4.getText().equals(CorrectAnswer)) {
                System.out.println("Då är det rätt och vi skickar detta tillservern");
            } else {
                System.out.println("Då är deeeeeeet feeeeeel");
            }
        }}}