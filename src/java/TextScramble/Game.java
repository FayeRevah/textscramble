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
 * This class contains the rules needed for the text scramble game to function.
 * Any modifications to the rule set must go here.
 *
 * @author West
 */
public class Game {

    public static final int MAX_CORRECT = 5; // guesses needed to win
    public static final int MAX_INCORRECT = 10; // guesses needed to lose
    private String word;   // the word to be guessed 
    private Random generator; // the random generator
    private String scrambled; // scrambled word
    private int time; //time on the game clock
    private int score; // the player's current score
    private int correctGuesses; // tracks this game's correct guesses
    private int incorrectGuesses; // tracks this game's incorrect guesses
    private boolean gameWon = false; // tracks the state of the game
    //Constructor

    public Game() {
        generator = new Random();
        newGame();
    }

    //to be called by handler
    //return values:
    //1 continue game, guess was either good or bad
    //2 game has been won
    //3 game has been lost
    //4 an error has occured
    
    public int getTime()
    {
        return time;
    }
    
    public int playGame(String guess, int gameTime) {
        time = gameTime;
        checkWord(guess);
        return checkState();
    }

    //Initalizes values for a new game
    public void newGame() {
        word = randomWord();
        scrambled = scrambleWord(word);
        time = 0;
        score = 0;
        correctGuesses = 0;
        incorrectGuesses = 0;
        gameWon = false;
    }

    public int getCorrect(){
        return correctGuesses;
    }
    
    public int getIncorrect(){
        return incorrectGuesses;
    }
    
    public int getScore() {
        return score;
    }

    public String getWord() {
        return word;
    }

    public String getScrambledWord() {
        return scrambled;
    }

    public void calculateScore() {
        score = (int)(correctGuesses * (1/log(time)) * 1000 - incorrectGuesses * 200);
        if(score < 0) score = 0;
    }

    // to be called whenever a guess is made. Assesses game state
    private int checkState() {
        if (incorrectGuesses >= MAX_INCORRECT) {
            gameWon = false;
            endGame();
            return 3;
        } else {
            if (correctGuesses >= MAX_CORRECT) {
                gameWon = true;
                endGame();
                return 2;
            }
        }
        return 1;
    }

    private void endGame()
    {
        calculateScore();
    }
    //Checks the user input against the correct word
    // time should be the current value of the game timer
    // if the word is correct this calls the next word and scrambles it
    public boolean checkWord(String input) {
        if (input.toLowerCase().equals(this.word.toLowerCase())) {
            correctGuesses++;
            randomWord();
            scrambled = scrambleWord(word);
            return true;
        } else {
            incorrectGuesses++;
            //checkState();
            return false;
        }
    }

    //Takes a String and creates a scrambled copy
    public String scrambleWord(String ar) {
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
    
    public void setScrambled(String scramb)
    {
        scrambled = scramb;
    }

    //Retrieves a random word from the DB
    private String randomWord() {
        Word randWord = WordDB.selectUser(generator.nextInt(100) + 1);
        word = randWord.getWord();
        return word; // to keep compiler happy
    }
    
    public void setWord(String wrd)
    {
        word = wrd;
    }
    
    public boolean getGameWon()
    {
        return gameWon;
    }

}
