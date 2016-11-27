package checkers;

import java.util.ArrayList;
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
    public void testCase1() {
        System.out.println("kingMeKinged");
        Move fin = new Move(0, 1);
        Checker instance = new Checker("w");
        instance.kingMe(fin);
        assertEquals("W", instance.getColor());
    }
    
    /**
    * Test of kingMe method, of class Checker (Piece is not converted to king).
    */
    @Test
    public void testCase2() {
        System.out.println("kingMeNotKinged");
        Move fin = new Move(1, 2);
        Checker instance = new Checker("w");
        instance.kingMe(fin);
        assertEquals("w", instance.getColor());
    }

    /**
     * Test of isKing method, of class Checker King.
     */
    @Test
    public void testCase3() {
        System.out.println("isKingTrue");
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
    public void testCase4() {
        System.out.println("isKingFasle");
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
    public void testCase5() {
        System.out.println("getColorRed");
        Checker instance = new Checker("r");
        String expResult = "r";
        String result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of getColor method, of class Checker White.
    */
    @Test
    public void testCase6() {
        System.out.println("getColorWhite");
        Checker instance = new Checker("w");
        String expResult = "w";
        String result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoves method, of class Checker (Move, normal piece).
     */
    @Test
    public void testCase7() {
        System.out.println("getMovesMoveNormal");
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
    * Test of getMoves method, of class Checker (Skip, normal piece).
    */
    @Test
    public void testCase8() {
        System.out.println("getMovesSkipNormal");
        String type = "skip";
        Move start = new Move(2, 3);
        Checker instance = new Checker("r");
        
        ArrayList<Move> expResult = new ArrayList();
        expResult.add(new Move(4, 5));//possible move 1
        expResult.add(new Move(4, 1));//possible move 2
        
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
    }
    
    /**
    * Test of getMoves method, of class Checker (Skip, king piece).
    */
    @Test
    public void testCase9() {
        System.out.println("getMovesSkipKing");
        String type = "skip";
        Move start = new Move(2, 3);
        Checker instance = new Checker("r");
        instance.kingMe(new Move(7, 3));
        ArrayList<Move> expResult = new ArrayList();
        expResult.add(new Move(4, 5));//possible move 1
        expResult.add(new Move(4, 1));//possible move 2
        expResult.add(new Move(0, 5));//possible move 3
        expResult.add(new Move(0, 1));//possible move 4
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
    }
    
    
    /**
    * Test of getMoves method, of class Checker (Skip, king piece).
    */
    @Test
    public void testCase10() {
        System.out.println("getMovesMoveKing");
        String type = "move";
        Move start = new Move(2, 3);
        Checker instance = new Checker("r");
        instance.kingMe(new Move(7, 3));
        ArrayList<Move> expResult = new ArrayList();
        expResult.add(new Move(3, 4));//possible move 1
        expResult.add(new Move(3, 2));//possible move 2
        expResult.add(new Move(1, 4));//possible move 3
        expResult.add(new Move(1, 2));//possible move 4
        ArrayList<Move> result = instance.getMoves(type, start);
        assertEquals(expResult, result);
    }
}