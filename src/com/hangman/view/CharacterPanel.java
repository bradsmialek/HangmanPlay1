package com.hangman.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class CharacterPanel extends JPanel implements ActionListener {

    private final JButton jb;
    private JLabel charGuessLabel;
    private JTextField charGuessField;
    private UnderScorePanelT placeHolders;
    public static String character;
    private HangmanPanelT hangmanPanel;


    public CharacterPanel(int width, int height, Color c) {

        this.setBackground(c);
        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        jb = new JButton();
        jb.setSize(100, 20);
        jb.setText("Submit");
        jb.addActionListener(this);
        this.setLayout(new FlowLayout());
        jb.setLocation(260,25);
        this.add(jb);
        jb.setBackground(Color.BLUE);
        jb.setOpaque(true);
        jb.setBorderPainted(false);
        jb.setForeground(Color.white);


        //
        charGuessField = new JTextField("a", 1);
        charGuessLabel = new JLabel("Enter A Character: ");
        placeHolders = new UnderScorePanelT();


        layoutComponents();
    }

    public void layoutComponents() {

        setLayout(null);

        //LAYOUT
        //LABELS
        charGuessLabel.setBounds(80, 23, 120, 30);

        //FIELDS
        charGuessField.setBounds(200, 20, 40, 30);
        charGuessField.setHorizontalAlignment(JTextField.CENTER);


        //ADD
        add(charGuessLabel);
        add(charGuessField);
        add(jb);
        validate();
        paint();
    }

    public void paint() {
        //Labels
        charGuessLabel.setForeground(Color.green);


    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);


        //DRAWS WIDTH AND COLOR OF STAND
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object eventOrigin = e.getSource();
        if(eventOrigin == jb) {
            character = charGuessField.getText().toLowerCase();

            placeHolders.check(character);

            String start = UnderScorePanelT.str;
            String replace = start.replace("", " ").trim();

            UnderScorePanelT.newEmptyStringLabel.setText(replace);
            UnderScorePanelT.newEmptyStringLabel.setBounds(180, 5, 450, 40);
            Font f = new Font("TimesRoman",Font.BOLD,40);
            UnderScorePanelT.newEmptyStringLabel.setFont(f);

            int count = UnderScorePanelT.count;
            System.out.println(count);
            hangmanPanel = new HangmanPanelT(count);
            int what = hangmanPanel.getNumBodyParts();
            System.out.println(what);
            //hangmanPanel.paintHangMan(g);

        }
    }


}
