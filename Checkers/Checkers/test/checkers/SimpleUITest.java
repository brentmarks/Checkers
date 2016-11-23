/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brentmarks
 */
public class SimpleUITest {
    
    public SimpleUITest() {
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
     * Test of skipOption method, of class SimpleUI.
     */
    @Test
    public void testSkipOption() {
        System.out.println("skipOption");
        Board b = null;
        String color = "";
        Move start = null;
        SimpleUI instance = new SimpleUI();
        String expResult = "";
        String result = instance.skipOption(b, color, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialLocationInput method, of class SimpleUI.
     */
    @Test
    public void testInitialLocationInput() {
        System.out.println("initialLocationInput");
        Board b = null;
        String name = "";
        int[] loc = null;
        String color = "";
        SimpleUI instance = new SimpleUI();
        int[] expResult = null;
        int[] result = instance.initialLocationInput(b, name, loc, color);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveInput method, of class SimpleUI.
     */
    @Test
    public void testMoveInput() {
        System.out.println("moveInput");
        Board b = null;
        String name = "";
        int[] loc = null;
        String color = "";
        SimpleUI instance = new SimpleUI();
        int[] expResult = null;
        int[] result = instance.moveInput(b, name, loc, color);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUsers method, of class SimpleUI.
     */
    @Test
    public void testCreateUsers() {
        System.out.println("createUsers");
        SimpleUI instance = new SimpleUI();
        User[] expResult = null;
        User[] result = instance.createUsers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
