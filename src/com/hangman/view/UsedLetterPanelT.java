package com.hangman.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class UsedLetterPanelT extends JPanel {

    private JLabel byLabel;

    public UsedLetterPanelT(int width, int height, Color c) {

        this.setBackground(c);
        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        this.setLayout(new FlowLayout());

        //LABEL
        byLabel = new JLabel("* Created @ BLUE MACRO LLC.   * BY Brad Smialek & Brandon Myers");

        layoutComponents();
    }

    public void layoutComponents() {

        this.setLayout(null);

        //LAYOUT
        byLabel.setBounds(50, 15, 500, 30);

        //ADD
        add(byLabel);
        validate();
        paint();
    }

    public void paint() {

        //Labels
        byLabel.setForeground(Color.green);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //DRAWS OUTSIDE BOX
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);

            //VERTICAL ^
        var j = 52;
        for (var i = 0; i < 100; i++) {
            g.drawString("*", 50, j);
            j += 5;
        }
            //HORIZONTAL ---------
        var k = 50;
        for (var i = 0; i < 100; i++) {
            g.drawString("*", k, 52);
            k += 5;
        }
    }

}
