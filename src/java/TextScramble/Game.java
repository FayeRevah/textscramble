/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains the rules needed for the text scramble
 * game to function. Any modifications to the rule set must
 * go here.
 * @author West
 */
public class Game {
    private String word;   // the word to be guessed 
    private Random generator; // the random generator
    private String scrambled; // scrambled word
    private int correctGuesses;
    private int incorrectGuesses;
    private int score;
    
    //Constructor
    public Game() {
        generator = new Random();
        word = randomWord();
        scrambled = scrambleWord(word);
        score = 0;
    }
    
    //Initalizes values for a new game
    public void newGame(){
        
    }
    
    public String getWord(){
        return word;
    }
    public String getScrambledWord(){
        return scrambled;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
   
    //Checks the user input against the correct word
    public Boolean checkWord(String input){
        if(input.toLowerCase().equals(this.word.toLowerCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Takes a String and creates a scrambled copy
    private String scrambleWord(String ar) {
        Random rnd = ThreadLocalRandom.current();
        char[] temp = ar.toCharArray();
        for (int i = ar.length() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            char a = temp[index];
            temp[index] = temp[i];
            temp[i] = a;
        }
        return new String(temp);
    }

    //Retrieves a random word from the DB
    private String randomWord() {
        Word randWord = WordDB.selectUser(generator.nextInt(100) + 1);
        word = randWord.getWord();
        return word; // to keep compiler happy
    }
    
}
