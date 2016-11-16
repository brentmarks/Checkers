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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of getInstance method, of class Board.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Board expResult = null;
        Board result = Board.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBoard method, of class Board.
     */
    @Test
    public void testPrintBoard() {
        System.out.println("printBoard");
        Board instance = null;
        instance.printBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movePiece method, of class Board.
     */
    @Test
    public void testMovePiece() {
        System.out.println("movePiece");
        String color = "";
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.movePiece(color, start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skipPiece method, of class Board.
     */
    @Test
    public void testSkipPiece() {
        System.out.println("skipPiece");
        String color = "";
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.skipPiece(color, start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of outOfBounds method, of class Board.
     */
    @Test
    public void testOutOfBounds_Move_Move() {
        System.out.println("outOfBounds");
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.outOfBounds(start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of outOfBounds method, of class Board.
     */
    @Test
    public void testOutOfBounds_Move() {
        System.out.println("outOfBounds");
        Move m = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.outOfBounds(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pieceChecks method, of class Board.
     */
    @Test
    public void testPieceChecks() {
        System.out.println("pieceChecks");
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.pieceChecks(start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveCheck method, of class Board.
     */
    @Test
    public void testMoveCheck() {
        System.out.println("moveCheck");
        Checker c = null;
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.moveCheck(c, start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skipCheck method, of class Board.
     */
    @Test
    public void testSkipCheck_Checker_Move() {
        System.out.println("skipCheck");
        Checker c = null;
        Move start = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.skipCheck(c, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skipCheck method, of class Board.
     */
    @Test
    public void testSkipCheck_3args() {
        System.out.println("skipCheck");
        Checker c = null;
        Move start = null;
        Move fin = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.skipCheck(c, start, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skip method, of class Board.
     */
    @Test
    public void testSkip() {
        System.out.println("skip");
        String color = "";
        Move start = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.skip(color, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flipColor method, of class Board.
     */
    @Test
    public void testFlipColor() {
        System.out.println("flipColor");
        String color = "";
        Board instance = null;
        String expResult = "";
        String result = instance.flipColor(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiece method, of class Board.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        int x = 0;
        int y = 0;
        Board instance = null;
        Checker expResult = null;
        Checker result = instance.getPiece(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sideConstant method, of class Board.
     */
    @Test
    public void testSideConstant() {
        System.out.println("sideConstant");
        String color = "";
        Board instance = null;
        int expResult = 0;
        int result = instance.sideConstant(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
