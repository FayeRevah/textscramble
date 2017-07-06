/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import static java.lang.Math.log;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains the rules needed for the text scramble
 * game to function. Any modifications to the rule set must
 * go here.
 * @author West
 */
public class Game {
    private static final int MAX_CORRECT = 5; // guesses needed to win
    private static final int MAX_INCORRECT = 10; // guesses needed to lose
    private String word;   // the word to be guessed 
    private Random generator; // the random generator
    private String scrambled; // scrambled word
    private int[] scoreList; // an array to keep track of the time at which the user scored
    private int score; // the player's current score
    private int correctGuesses; // tracks this game's correct guesses
    private int incorrectGuesses; // tracks this game's incorrect guesses
    private boolean gameWon; // tracks the state of the game
    //Constructor
    public Game() {
        generator = new Random();
    }
    
    //Initalizes values for a new game
    public void newGame(){
        word = randomWord();
        scrambled = scrambleWord(word);
        score = 0;
        correctGuesses = 0;
        incorrectGuesses = 0;
        gameWon = false;
    }
    
    public boolean getGameWon(){
        return gameWon;
    }
    
    public int getScore(){
        return score;
    }
    
    private void endGame(){
        calculateScore();
    }
    
    public String getWord() {
        return word;
    }

    public String getScrambledWord() {
        return scrambled;
    }
    
    private void calculateScore(){
        int logVal = 1;
        for(int i = 0; i < scoreList.length; i++){
            logVal += scoreList[i];
        }
        score = (int) (1000 * log(logVal));
    }
    
    // to be called whenever a guess is made. Assesses game state
    private void checkState(){
        if(incorrectGuesses >= MAX_INCORRECT){
            gameWon = false;
        }else{
            if(correctGuesses >= MAX_CORRECT){
                gameWon = true;
                endGame();
            }
        }
    }
    

   
    //Checks the user input against the correct word
    // time should be the current value of the game timer
    // if the word is correct this calls the next word and scrambles it
    public boolean checkWord(String input, int time){
        if(input.toLowerCase().equals(this.word.toLowerCase())){
            if(correctGuesses == 0) scoreList[correctGuesses] = time;
            else scoreList[correctGuesses] = time - scoreList[correctGuesses - 1];

            correctGuesses++;
            checkState();
            randomWord();
            scrambleWord(word);
            return true;
        }
        else{
            incorrectGuesses++;
            checkState();
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
