/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;
/**
 *
 * @author faigarevah
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    //newGame test, all values initialized to 0
    @Test
    public void testNewGame() {
        Game instance = new Game();
        System.out.println("newGame");
        int correct = instance.getCorrect();
        assertEquals(correct, 0);
        int incorrect = instance.getIncorrect();
        assertEquals(incorrect, 0);
        boolean gW = instance.getGameWon();
        assertEquals(gW, false);
        String word = instance.getWord();
        String scrambled = instance.getScrambledWord();
        assertFalse(word.equals(scrambled));
        int score = instance.getScore();
        assertEquals(score, 0);
        int time = instance.getTime();
        assertEquals(time, 0);
    }
    
    @Test
    public void testSetandGetWord()
    {
        System.out.println("Set and Get word");
        Game instance = new Game();
        instance.setWord("over");
        String word = instance.getWord();
        assertEquals(word, "over");
    }
    
    @Test
    public void testPlayGame()
    {
        
        System.out.println("PlayGame");
        Game instance = new Game();
        instance.setWord("goodbye");
        instance.setScrambled(instance.scrambleWord("goodbye"));
        
        int result, correct, incorrect;
        
        for(int i = 0; i < Game.MAX_INCORRECT - 1; i++)
        {
            result = instance.playGame("oodgbye", 0);
            //continue game, neither lost nor won
            assertEquals(result, 1);
            correct = instance.getCorrect();
            incorrect = instance.getIncorrect();
            assertEquals(correct, 0);
            assertEquals(incorrect, i + 1);
            assertEquals(instance.getTime(), 0);
        }
        
        //lose game, return 3
        result = instance.playGame("oodgbye", 0);
        assertEquals(result, 3);
        
        Game instance2 = new Game();
        //guess correctly
        instance2.setWord("over");
        instance2.setScrambled(instance.scrambleWord("over"));
        
        result = instance2.playGame("over", 0);
        assertEquals(result, 1);
        
        correct = instance2.getCorrect();
        assertEquals(correct, 1);
        
        //check if set new word
        String word = instance2.getWord();
        assertFalse(word.equals("over"));
        
        for(int i = 1; i < Game.MAX_CORRECT - 1; i++)
        {
            word = instance2.getWord();
            result = instance2.playGame(word, 0);
            assertEquals(result, 1);
            assertFalse(instance2.getWord().equals(word));
            assertEquals(instance2.getCorrect(), i + 1);
        }
        
        //win game
        word = instance2.getWord();
        result = instance2.playGame(word, 0);
        assertEquals(result, 2);   
        
        //Game of alternates
        
        Game instance3 = new Game();
        instance3.setWord("tester");
        
        //wrong guess 1
        result = instance3.playGame("a", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 1);
        correct= instance3.getCorrect();
        assertEquals(correct, 0);
        
        //wrong guess 2
        result = instance3.playGame("b", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 2);
        correct= instance3.getCorrect();
        assertEquals(correct, 0);
        
        //right guess 1
        result = instance3.playGame("tester", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 2);
        correct= instance3.getCorrect();
        assertEquals(correct, 1);
        
        //wrong guess 3, repeat same incorrect guess
        result = instance3.playGame("a", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 3);
        correct = instance3.getCorrect();
        assertEquals(correct, 1);
        
        //right guess 2
        instance3.setWord("oval");
        result = instance3.playGame("oval", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 3);
        correct= instance3.getCorrect();
        assertEquals(correct, 2);
        
        //right guess 3
        instance3.setWord("square");
        result = instance3.playGame("square", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 3);
        correct= instance3.getCorrect();
        assertEquals(correct, 3);
        
        //wrong guess 4
        instance3.setWord("diamond");
        result = instance3.playGame("oval", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 4);
        correct= instance3.getCorrect();
        assertEquals(correct, 3);
        
        //wrong guess 5
        result = instance3.playGame("---", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 5);
        correct= instance3.getCorrect();
        assertEquals(correct, 3);
        
        //right guess 4
        instance3.setWord("shape");
        result = instance3.playGame("shape", 0);
        assertEquals(result, 1);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 5);
        correct= instance3.getCorrect();
        assertEquals(correct, 4);
        
        //right guess 5, game won
        instance3.setWord("square");
        result = instance3.playGame("square", 0);
        assertEquals(result, 2);
        incorrect = instance3.getIncorrect();
        assertEquals(incorrect, 5);
        correct= instance3.getCorrect();
        assertEquals(correct, 5);
    }
    
    @Test
    public void testCheckWord()
    {
        Game instance = new Game();
        instance.setWord("tester");
        instance.setScrambled(instance.scrambleWord("tester"));
        
        boolean checkWord;
        checkWord = instance.checkWord("tester");
        assertEquals(checkWord, true);
        
        instance.setWord("tester");
        checkWord = instance.checkWord("TESTER");
        assertEquals(checkWord, true);
        
        instance.setWord("tester");
        checkWord = instance.checkWord("TestEr");
        assertEquals(checkWord, true);
        
        instance.setWord("tester");
        checkWord = instance.checkWord("testpr");
        assertEquals(checkWord, false);
        
        instance.setWord("tester");
        checkWord = instance.checkWord("tseter");
        assertEquals(checkWord, false);
        
        instance.setWord("tester");
        checkWord = instance.checkWord("__1esr");
        assertEquals(checkWord, false);
    }
    
    @Test
    public void testCalculateScore()
    {
        Game instance2 = new Game();
        //guess correctly
        instance2.setWord("over");
        instance2.setScrambled(instance2.scrambleWord("over"));

        String word;
        
        for(int i = 0; i < Game.MAX_CORRECT; i++)
        {
            word = instance2.getWord();
            instance2.playGame(word, i * 15);
        }
        
        instance2.calculateScore();
        assertEquals(instance2.getTime(), 60);
        assertEquals(instance2.getScore(), 1221);
    }  
    

}
