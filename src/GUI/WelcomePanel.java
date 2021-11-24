package GUI;

import Client.Client;
import Server.Player;
import Server.ServerLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WelcomePanel extends JPanel implements ActionListener {
    ServerLogic categories = new ServerLogic();
    JLabel jLabel = new JLabel();
    JButton jButton = new JButton();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    String choice;
    Client client;

    public WelcomePanel(Client client) throws IOException {
        this.client = client;
        this.setVisible(true);
        jLabel.setOpaque(true);
        setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(6, 1));
        jLabel.setText("Welcome to Quizkampen! Choose a category:");
        jButton.setText(""+categories.CategoryGetter().get(0));
        jButton1.setText(""+categories.CategoryGetter().get(1));
        jButton2.setText(""+categories.CategoryGetter().get(2));
        jButton.addActionListener(this);
        jButton1.addActionListener(l -> actionPerformed2());
        jButton2.addActionListener(l -> actionPerformed3());

        add(jLabel);
        add(jButton);
        add(jButton1);
        add(jButton2);
    }


    public void actionPerformed(ActionEvent e) {
       System.out.println("KLICKAT 1!");
       choice = ("CAT"+jButton.getText());
       client.setCategory(choice);
        //out.println(choice);

    }
    public void actionPerformed2() {
        System.out.println("KLICKAT 2!");
    }
    public void actionPerformed3() {
        System.out.println("KLICKAT 3!");
    }
    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }
}
