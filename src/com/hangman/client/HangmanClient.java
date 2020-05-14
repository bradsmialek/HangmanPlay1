package com.hangman.client;

import com.hangman.view.*;

import javax.swing.*;
import java.awt.*;
//TODO:  fix imports specific
/**
 * Created by bradsmialek on Tue - 5/12/20 @ 9:05 PM
 */
public class HangmanClient extends JFrame{

    //TODO:  Change file names remove T
    private DataPanelT dataPanel;
    private HangmanPanelT hangmanPanel;
    private UnderScorePanelT underScorePanel;
    private UsedLetterPanelT usedLetterPanel;
    private CategoryPanel categoryPanel;
    private CharacterPanel   characterPanel;

    private static final Color CB = Color.BLACK;
    private static final int w = 450;

    public HangmanClient() {

        //FRAME
        setTitle("Hangman 2020");
        setResizable(true);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NEW OBJECT INS
        usedLetterPanel = new UsedLetterPanelT( w, 405, CB);
        hangmanPanel    = new HangmanPanelT( w, 405, CB);
        underScorePanel = new UnderScorePanelT( w, 95, CB);
        dataPanel       = new DataPanelT( w, 95, CB);
        categoryPanel   = new CategoryPanel( w, 80, CB);
        characterPanel  = new CharacterPanel( w, 80, CB);

        //
        Container cont = this.getContentPane();
        cont.setLayout(new FlowLayout(0, 0, 0));

        getContentPane().add(usedLetterPanel);
        getContentPane().add(hangmanPanel);
        getContentPane().add(underScorePanel);
        getContentPane().add(dataPanel);
        getContentPane().add(categoryPanel);
        getContentPane().add(characterPanel);

        setVisible(true);

    }

    //
    public static void main(String[] args) {
        JFrame frame = new HangmanClient();
    }
}
