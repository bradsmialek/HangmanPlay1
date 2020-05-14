package com.hangman.view;

/**
 * Created by bradsmialek on Wed - 5/13/20 @ 6:41 AM
 */
public class WordBank {
    private static String[] sportBank = {"soccer", "baseball", "bmx", "coaches", "running", "volleyball", "swimming"};
    private static String[] foodBank = {"pizza", "hotdog", "chips", "hamburger", "cheese" , "yogurt" , "soda", "eggs"};
    private static String[] animalBank = {"bird", "snake", "lion", "bear", "dog", "cat", "mouse"};
    public static String word;

    public String randWord(String category) {

        switch (category) {
            case "sports":
                this.word = randomWordGenerator(sportBank);
                break;
            case "food":
                this.word = randomWordGenerator(foodBank);
                break;
            case "animals":
                this.word = randomWordGenerator(animalBank);
                break;
        }

        return this.word;
    }

    public String randomWordGenerator(String[] array) {

        int position = (int)(Math.random() * array.length);
        String result = array[position];
        return result;
    }
}
