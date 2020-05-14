package com.hangman.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class DataPanelT extends JPanel {

    private JLabel guessesLeftLabel;
    private JLabel winsLabel;
    private JLabel lossLabel;

    public DataPanelT(int width, int height, Color c) {

        //CREATE COMPONENTS
        guessesLeftLabel = new JLabel("Guesses Left: ");
        winsLabel = new JLabel("Wins: ");
        lossLabel = new JLabel("Loss: ");

        this.setBackground(c);
        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        this.setLayout(new FlowLayout());

        layoutComponents();

    }

    public void layoutComponents() {

        setLayout(null);

        //LAYOUT LABELS
        guessesLeftLabel.setBounds(80, 30, 100, 20);
        winsLabel.setBounds(280, 5, 50, 20);
        lossLabel.setBounds(280, 30, 50, 20);

        //ADD
        add(winsLabel);
        add(lossLabel);
        add(guessesLeftLabel);
        validate();
        paint();
    }

    public void paint() {

        //Labels
        winsLabel.setForeground(Color.green);
        lossLabel.setForeground(Color.green);
        guessesLeftLabel.setForeground(Color.green);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //DRAWS WIDTH AND COLOR OF STAND
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);


        //DRAWS OUTSIDE BOX
            //VERTICAL
        var j = 0;
        for (var i = 0; i < 100 ; i++) {
            g.drawString("*", 400, j);
            j += 5;
        }
            //HORIZONTAL
        var k = 0;
        for (var i = 0; i < 80; i++) {
            g.drawString("*", k, 100);
            k += 5;
        }
    }

}
