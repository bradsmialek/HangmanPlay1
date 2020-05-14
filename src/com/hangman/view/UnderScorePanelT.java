package com.hangman.view;

import jdk.jfr.Category;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class UnderScorePanelT extends JPanel {

    //FIELDS
    public static JLabel newEmptyStringLabel;
    public static int count = 0;
    public static String character = CharacterPanel.character;
    public static String str;
    public static String word;
    public static String newEmptyString = "";



    //CONSTRUCTORS
    public UnderScorePanelT(int width, int height, Color c) {

        this.setBackground(c);
        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        this.setLayout(new FlowLayout());

        newEmptyStringLabel = new JLabel("Pick A Category & Get New Word");
        Font f = new Font("TimesRoman",Font.BOLD,25);
        newEmptyStringLabel.setFont(f);

        layoutComponents();
    }

    public UnderScorePanelT() {

    }

    public static String getStr() {
        return str;
    }

    //METHODS
    public void guess(String word) {
        this.word = word;
//        System.out.println("in guess");
//        System.out.println(word);

        char[] charSpaces = new char[word.length()];
        int i = 0;
        while (i < word.length()) {
            charSpaces[i] = '_';
            if (word.charAt(i) == ' ') {
                charSpaces[i] = ' ';
            }
            i++;
        }
        str = String.valueOf(charSpaces);

    }


    public void check(String character) {
        System.out.println("in check");
        newEmptyString = "";

        for (int i = 0 ; i < word.length() ; i++) {

            if( word.charAt(i) == character.charAt(0)) {

                newEmptyString += character.charAt(0);
//                System.out.println(newEmptyString);
            }
            else if(str.charAt(i) != '_') {
                newEmptyString += word.charAt(i);
//                System.out.println(newEmptyString);
            }
            else {
                newEmptyString += "_";
//                System.out.println(newEmptyString);
            }

        }
//
        if(str.equals(newEmptyString)) {
            count ++;

            System.out.println(count);
        }
        else {
            str = newEmptyString;
            System.out.println("true");
        }
        if(str.equals(word)) {
            System.out.println(" you win");
        }


    }


    public void layoutComponents() {

        setLayout(null);

        //LAYOUT LABEL
        newEmptyStringLabel.setBounds(80, 5, 450, 40);

        //ADD
        add(newEmptyStringLabel);
        validate();
        paint();
    }

    public void paint() {

        //Labels
        newEmptyStringLabel.setForeground(Color.cyan);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        //DRAWS WIDTH AND COLOR OF STAND
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);

        //DRAWS OUTSIDE BOX
        //VERTICAL ^
        var j = 0;
        for (var i = 0; i < 100; i++) {
            g.drawString("*", 50, j);
            j += 5;
        }
        //HORIZONTAL ---------
        var k = 50;
        for (var i = 0; i < 100; i++) {
            g.drawString("*", k, 100);
            k += 5;
        }

    }

}
