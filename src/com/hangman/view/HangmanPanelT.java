package com.hangman.view;

import javax.swing.*;
import java.awt.*;


/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class HangmanPanelT extends JPanel {

    public int numBodyParts;

    public HangmanPanelT(int width, int height, Color c) {

        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        this.setLayout(new FlowLayout());
        layoutComponents();
    }

    public HangmanPanelT(int numBodyParts) {
        setNumBodyParts(numBodyParts);

    }

    public int getNumBodyParts() {
        return numBodyParts;
    }

    public void setNumBodyParts(int numBodyParts) {
        this.numBodyParts = numBodyParts;

    }

    public void layoutComponents() {

        setLayout(null);

        //LAYOUT
        //LABELS


        //FIELDS



        //ADD
//        validate();
        paint();
    }

    public void paint() {
        //Labels

    }


    // counts the number of hangman body parts

    public void paintHangMan(Graphics g) {
        System.out.println("here");
        System.out.println(numBodyParts);
        if (numBodyParts >= 1) {
            // draw face
            g.setColor(Color.WHITE);
            g.fillOval(145, 152, 70, 60);
            // draw eyes
            g.setColor(Color.red);
            g.fillOval(165, 172, 10, 10);
            g.fillOval(185, 172, 10, 10);
            // smile
            g.setColor(Color.RED);
            g.drawArc(160, 187, 40, 10, -10, -180);

            if (numBodyParts >= 2) {
                // body
                g.setColor(Color.WHITE);
                g.fillRect(170, 212, 20, 80);
            }

            if (numBodyParts >= 3) {
                // left arm
                g.setColor(Color.WHITE);
                g.fillRect(130, 232, 45, 15);
            }

            if (numBodyParts >= 4) {
                // right arm
                g.setColor(Color.WHITE);
                g.fillRect(185, 232, 45, 15);
            }

            if (numBodyParts >= 5) {
                // left foot
                g.setColor(Color.WHITE);
                g.fillRect(140, 292, 30, 15);
            }

            if (numBodyParts >= 6) {
                // right foot
                g.setColor(Color.WHITE);
                g.fillRect(190, 292, 30, 15);
                // draw eyes
                g.setColor(Color.red);
                g.drawLine(175, 180, 165, 170);
                g.drawLine(195, 180, 185, 170);
                g.drawLine(165, 180, 175, 170);
                g.drawLine(185, 180, 195, 170);
                //MOUTH
                g.drawArc(160, 192, 40, 10, 10, 180);

            }
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.BLACK);

        //DRAWS WIDTH AND COLOR OF STAND
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);

        // ERECT STAND
        g.drawLine(300, 100, 300, 380); // This is long line going up
        g.setColor(Color.WHITE);
        g.drawLine(180, 100, 180, 150); // This is the rope
        g.setColor(Color.RED);
        g.drawLine(130, 380, 350, 380); // This is the bottom horizontal line
        g.setColor(Color.BLUE);
        g.drawLine(170, 100, 300, 100); // This is the top horizontal line
        g.setColor(Color.ORANGE);
        g.drawLine(240, 101, 300, 150); // This is the diagonal line


        // DRAWS OUTSIDE BOX
            //VERTICAL
        var j = 52;
        for (var i = 0; i < 100; i++) {
            g.drawString("*", 400, j);
            j += 5;
        }
            //HORIZONTAL
        var k = 0;
        for (var i = 0; i < 80; i++) {
            g.drawString("*", k, 52);
            k += 5;
        }



    }
}
