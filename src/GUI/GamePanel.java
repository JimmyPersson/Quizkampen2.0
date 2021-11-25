package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        jl1.setPreferredSize(new Dimension(400,100));

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
        jb1.setText(Answer1);
        jb1.addActionListener(this);
        jb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                jb1.setContentAreaFilled(false);
                jb1.setBackground(Color.GREEN);
                jb1.setOpaque(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                jb1.setOpaque(true);
                jb1.setBorderPainted(false);
                jb1.setBackground(Color.white);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb2, gbc);
        jb2.setText(Answer2);
        jb2.addActionListener(this);
        jb2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                jb2.setContentAreaFilled(false);
                jb2.setBackground(Color.RED);
                jb2.setOpaque(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                jb2.setOpaque(true);
                jb2.setBorderPainted(false);
                jb2.setBackground(Color.white);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb3, gbc);
        jb3.setText(Answer3);
        jb3.addActionListener(this);
        jb3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                jb3.setContentAreaFilled(false);
                jb3.setBackground(Color.RED);
                jb3.setOpaque(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                jb3.setOpaque(true);
                jb3.setBorderPainted(false);
                jb3.setBackground(Color.white);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jb4, gbc);
        jb4.setText(Answer4);
        jb4.addActionListener(this);
        jb4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                jb4.setContentAreaFilled(false);
                jb4.setBackground(Color.RED);
                jb4.setOpaque(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                jb4.setOpaque(true);
                jb4.setBorderPainted(false);
                jb4.setBackground(Color.white);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
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

            jb1.setText(Answer1);
            jb2.setText(Answer2);
            jb3.setText(Answer3);
            jb4.setText(Answer4);
        }
        else {
            out.println("ENDROUND"+chosenCat+score);
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