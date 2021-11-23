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

    private String Rubrik1;
    private String Rubrik2;
    private String Rubrik3;
    private String Rubrik4;
    private String Rubrik5;
    private String köttfärs;


    public GamePanel(String responseInput, PrintWriter out) {
        this.out = out;
        this.responseInput = responseInput;
        getStringsFromRegex(responseInput);

        setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridLayout(6, 1));


        jl1.setText(Rubrik1);
        add(jl1);

        jb1.setText(Rubrik2);
        jb1.addActionListener(this);
        add(jb1);

        jb2.setText(Rubrik3);
        jb2.addActionListener(this);
        add(jb2);

        jb3.setText(Rubrik4);
        jb3.addActionListener(this);
        add(jb3);

        jb4.setText(Rubrik5);
        jb4.addActionListener(this);
        add(jb4);

    }


    public void getStringsFromRegex(String responseInput) {
        String[] temp = responseInput.split("--");
        Rubrik1 = temp[0];
        Rubrik2 = temp[1];
        Rubrik3 = temp[2];
        Rubrik4 = temp[3];
        Rubrik5 = temp[4];
        köttfärs = temp[4];
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == jb1) {
            if (jb1.getText().equals(köttfärs)) {
                out.println("Då är det rätt och vi skickar detta tillservern");
            } else {
                out.println("Då är deeeeeeet feeeeeel");
            }


            if (e.getSource() == jb2) {
                if (jb2.getText().equals(köttfärs)) {
                    out.println("Då är det rätt och vi skickar detta tillservern");
                } else {
                    out.println("Då är deeeeeeet feeeeeel");
                }


            }

        }
    }

}