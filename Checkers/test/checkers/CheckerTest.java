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
 * @author Brent Marks
 * @author Vruti Vaghela
 * @author Vidhi Patel
 */
public class CheckerTest {

    /**
     * Test of kingMe method, of class Checker (Piece is converted to king). 
     */
    @Test
    public void testKingMeKinged() {
        System.out.println("kingMe");
        Move fin = new Move(0, 1);
        Checker instance = new Checker("w");
        instance.kingMe(fin);
        assertEquals("W", instance.getColor());
    }
    
    /**
    * Test of kingMe method, of class Checker (Piece is not converted to king).
    */
    @Test
    public void testKingMeNotKinged() {
        System.out.println("kingMe");
        Move fin = new Move(1, 2);
        Checker instance = new Checker("w");
        instance.kingMe(fin);
        assertEquals("w", instance.getColor());
    }

    /**
     * Test of isKing method, of class Checker King.
     */
    @Test
    public void testIsKingTrue() {
        System.out.println("isKing");
        Checker instance = new Checker("r");
        instance.kingMe(new Move(7, 0));
        boolean expResult = true;
        boolean result = instance.isKing();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isKing method, of class Checker Not King.
     */
    @Test
    public void testIsKingFalse() {
        System.out.println("isKing");
        Checker instance = new Checker("r");
        instance.kingMe(new Move(6, 1));
        boolean expResult = false;
        boolean result = instance.isKing();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Checker Red.
     */
    @Test
    public void testGetColorRed() {
        System.out.println("getColor");
        Checker instance = new Checker("r");
        String expResult = "r";
        String result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of getColor method, of class Checker White.
    */
    @Test
    public void testGetColorWhite() {
        System.out.println("getColor");
        Checker instance = new Checker("w");
        String expResult = "w";
        String result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoves method, of class Checker (Move).
     */
    @Test
    public void testGetMovesMove() {
        System.out.println("getMoves");
        String type = "move";
        Move start = new Move(2, 3);
        Checker instance = new Checker("r");
        ArrayList<Move> expResult = new ArrayList();
        expResult.add(new Move(3, 4));//possible move 1
        expResult.add(new Move(3, 2));//possible move 2
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
    }
    
    /**
    * Test of getMoves method, of class Checker (Skip).
    */
    @Test
    public void testGetMovesSkip() {
        System.out.println("getMoves");
        String type = "skip";
        Move start = new Move(2, 3);
        Checker instance = new Checker("r");
        ArrayList<Move> expResult = new ArrayList();
        expResult.add(new Move(2 + 2, 3 + 2));
        expResult.add(new Move(2 + 2, 3 - 2));
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
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
