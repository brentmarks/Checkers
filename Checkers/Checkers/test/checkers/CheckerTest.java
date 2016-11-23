/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.util.ArrayList;
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
public class CheckerTest {
    
    public CheckerTest() {
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
     * Test of kingMe method, of class Checker.
     */
    @Test
    public void testKingMe() {
        System.out.println("kingMe");
        Move fin = null;
        Checker instance = null;
        instance.kingMe(fin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isKing method, of class Checker.
     */
    @Test
    public void testIsKing() {
        System.out.println("isKing");
        Checker instance = null;
        boolean expResult = false;
        boolean result = instance.isKing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Checker.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Checker instance = null;
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoves method, of class Checker.
     */
    @Test
    public void testGetMoves() {
        System.out.println("getMoves");
        String type = "";
        Move start = null;
        Checker instance = null;
        ArrayList<Move> expResult = null;
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sideConstant method, of class Checker.
     */
    @Test
    public void testSideConstant() {
        System.out.println("sideConstant");
        String color = "";
        Checker instance = null;
        int expResult = 0;
        int result = instance.sideConstant(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Checker.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Checker instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
