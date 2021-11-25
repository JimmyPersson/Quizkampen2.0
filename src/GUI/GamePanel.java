package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


public class GamePanel extends JPanel implements ActionListener {

    PrintWriter out;
    BufferedReader br;
    String category;
    JLabel jl1 = new JLabel("", SwingConstants.CENTER);
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();

    private String chosenCat;
    private String Question;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String Answer4;
    private String CorrectAnswer;
    private ArrayList<String> questionList = new ArrayList();
    private int score = 0;
    private int loop = 0;
    private int loopLimit;
    private ArrayList<String> buttonList = new ArrayList<>();


    public GamePanel(PrintWriter out, String responseInput) throws IOException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/Server/properties.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        loopLimit = Integer.parseInt(p.getProperty("customQuestionLimit", "4"));
        loopLimit--;
        System.out.println(loopLimit);
        this.out = out;
        this.chosenCat = responseInput.substring(3);

        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(30, 120, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        jl1.setFont(new Font("Arial", Font.BOLD, 16));
        jl1.setOpaque(true);
        jl1.setPreferredSize(new Dimension(400, 100));

        jb1.setFont(new Font("Arial", Font.BOLD, 16));
        jb2.setFont(new Font("Arial", Font.BOLD, 16));
        jb3.setFont(new Font("Arial", Font.BOLD, 16));
        jb4.setFont(new Font("Arial", Font.BOLD, 16));


        br = new BufferedReader(new FileReader("src/Server/Database.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            category = responseInput.substring(3);
            System.out.println(category);
            for (line = br.readLine(); line != null; line = br.readLine()) {

                if (line.startsWith(category)) {
                    for (int i = 0; i < 20; i++) {
                        questionList.add(br.readLine());
                    }
                }
            }
        }

        Question = questionList.get(0);
        Answer1 = questionList.get(1);
        Answer2 = questionList.get(2);
        Answer3 = questionList.get(3);
        Answer4 = questionList.get(4);
        CorrectAnswer = Answer1;

        buttonList.add(Answer1);
        buttonList.add(Answer2);
        buttonList.add(Answer3);
        buttonList.add(Answer4);
        Collections.shuffle(buttonList);

        jb1.setText(buttonList.get(0));
        jb2.setText(buttonList.get(1));
        jb3.setText(buttonList.get(2));
        jb4.setText(buttonList.get(3));

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jl1, gbc);
        jl1.setText(Question);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb1, gbc);
        jb1.addActionListener(this);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb2, gbc);
        jb2.addActionListener(this);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb3, gbc);
        jb3.addActionListener(this);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb4, gbc);
        jb4.addActionListener(this);
    }

    public void updateGamepanel() {


        if (loop < loopLimit) {
            Question = questionList.get(5 + 5 * loop);
            Answer1 = questionList.get(6 + 5 * loop);
            Answer2 = questionList.get(7 + 5 * loop);
            Answer3 = questionList.get(8 + 5 * loop);
            Answer4 = questionList.get(9 + 5 * loop);

            setLoop(loop + 1);
            CorrectAnswer = Answer1;

            jl1.setText(Question);

            buttonList.clear();
            buttonList.add(Answer1);
            buttonList.add(Answer2);
            buttonList.add(Answer3);
            buttonList.add(Answer4);

            Collections.shuffle(buttonList);

            jb1.setText(buttonList.get(0));
            jb2.setText(buttonList.get(1));
            jb3.setText(buttonList.get(2));
            jb4.setText(buttonList.get(3));


        } else {
            out.println("ENDROUND" + chosenCat + score);
        }
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb1) {
            if (jb1.getText().equals(CorrectAnswer)) {
                score++;
                updateGamepanel();
            } else {
                updateGamepanel();
            }
        }
        if (e.getSource() == jb2) {
            if (jb2.getText().equals(CorrectAnswer)) {
                score++;
                updateGamepanel();
            } else {
                updateGamepanel();
            }
        }
        if (e.getSource() == jb3) {
            if (jb3.getText().equals(CorrectAnswer)) {
                score++;
                updateGamepanel();
            } else {

                updateGamepanel();
            }
        }
        if (e.getSource() == jb4) {
            if (jb4.getText().equals(CorrectAnswer)) {
                score++;
                updateGamepanel();
            } else {
                updateGamepanel();
            }
        }
    }
}