/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

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
public class WordDBTest {
    
    public WordDBTest() {
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
     * Test of selectUser method, of class WordDB.
     */
    @Test
    public void testSelectUser() {
        System.out.println("selectUser");
        Integer id = 10;
        String expResult = "trick";
        String result = WordDB.selectUser(id).getWord();
        assertEquals(expResult, result);
    }
    
}
