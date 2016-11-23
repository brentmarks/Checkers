package checkers;

/**** @author brentmarks*/
/**
 * OVERVEIW: This is a mutable class, which takes in the x and y coordinates of 
 *           a piece.
 * @author VIDHI PATEL
 */
public class Move {
    
    private int x;
    private int y;
    
    /**
     * Takes the x and y coordinates of the piece.
     * @param x
     * @param y 
     */
    public Move(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Sets the x coordinates
     * @param x 
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Sets the Y coordinates
     * @param y 
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * @return the x coordinates
     */
    public int getX(){
        return x;
    }
    /**
     * @return the y coordinate
     */
    public int getY(){
        return y;
    }
    /**
     * @param m
     * @return the object as a MOVE object with x and y coordinates
     */
    @Override
    public boolean equals(Object m){
        return m instanceof Move && ((Move)m).x == x && ((Move)m).y == y;
    }
    /**
     * @return the x and y coordinates of the MOVE object
     */
    @Override
    public String toString(){
        return "Move [ " + x + ", " + y + " ]";
    }
}