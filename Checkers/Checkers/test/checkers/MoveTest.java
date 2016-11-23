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
public class MoveTest {
    
    public MoveTest() {
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
     * Test of setX method, of class Move.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Move instance = null;
        instance.setX(x);
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Move.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Move instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Move.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Move instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Move.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Move instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Move.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object m = null;
        Move instance = null;
        boolean expResult = false;
        boolean result = instance.equals(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Move.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Move instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
