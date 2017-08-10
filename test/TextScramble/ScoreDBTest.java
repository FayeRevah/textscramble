/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class ScoreDBTest {
    
    public ScoreDBTest() {
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

    /**
     * Test of selectScores method, of class ScoreDB.
     */
    @Test
    public void testSelectScores() {
        System.out.println("selectScores");
        List<Score> expResult = ScoreDB.selectScores();
        List<Score> result = ScoreDB.selectScores();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class ScoreDB.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Score score = new Score();
        score.setInitials("T$T");
        score.setFinalTime(9999);
        score.setScore(1);
        ScoreDB.insert(score);
    }
    
}
