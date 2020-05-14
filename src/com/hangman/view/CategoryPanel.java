package com.hangman.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:07 PM
 */
public class CategoryPanel extends JPanel implements ActionListener {

    private JLabel pickCategoryLabel;
    private JComboBox categoryCombo;
    private WordBank wordBank;
    private UnderScorePanelT placeHolders = new UnderScorePanelT();
    private final JButton jb;



    public CategoryPanel(int width, int height, Color c) {

        this.setBackground(c);
        Dimension dimension = new Dimension(width, height);
        this.setPreferredSize(dimension);
        jb = new JButton();
        jb.setSize(120, 30);
        jb.setText("New Word");
        jb.addActionListener(this);
        this.setLayout(new FlowLayout());
        jb.setLocation(320,20);
        jb.setBackground(Color.green);
        jb.setOpaque(true);
        jb.setBorderPainted(false);
        jb.setForeground(Color.BLUE);


        //CREATE COMPONENTS
        pickCategoryLabel = new JLabel("Pick A Category: ");
        //COMBO BOX
        categoryCombo = new JComboBox();

        wordBank = new WordBank();

        //SETUP COMBO BOX
        DefaultComboBoxModel categoryModel = new DefaultComboBoxModel();
        categoryModel.addElement("Sports");
        categoryModel.addElement("Food");
        categoryModel.addElement("Animals");
        categoryCombo.setModel(categoryModel);
        categoryCombo.setSelectedIndex(0);

        layoutComponents();
    }

    public void layoutComponents() {

        this.setLayout(null);

        //LAYOUT
            //LABELS
        pickCategoryLabel.setBounds(80, 23, 120, 30);

            //COMBO BOX
        categoryCombo.setBounds(190, 21, 100, 30);



        //ADD
        add(jb);
        add(categoryCombo);
        add(pickCategoryLabel);
        validate();
        paint();
    }

    public void paint() {

        //Labels
        pickCategoryLabel.setForeground(Color.green);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);


        //DRAWS WIDTH AND COLOR OF STAND
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        Stroke stroke = new BasicStroke(6f);
        g2d.setStroke(stroke);


        //DRAWS OUTSIDE BOX
//        var j = 0;
//        for (var i = 0; i < 100 ; i++) {
//            g.drawString("*", 20, j);
//            j += 5;
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object eventOrigin = e.getSource();
        if(eventOrigin == jb) {
            String wordCategory = (String) categoryCombo.getSelectedItem();  // get topic

            String randWordBack = wordBank.randWord(wordCategory.toLowerCase()); // get random word back
            System.out.println(randWordBack);

            placeHolders.guess(randWordBack);
            String start = UnderScorePanelT.str;
            String replace = start.replace("", " ").trim();

            UnderScorePanelT.newEmptyStringLabel.setText(replace);
            UnderScorePanelT.newEmptyStringLabel.setBounds(180, 5, 450, 40);
            Font f = new Font("TimesRoman",Font.BOLD,40);
            UnderScorePanelT.newEmptyStringLabel.setFont(f);

        }
    }
}






