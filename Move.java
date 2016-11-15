package checkers;

/**
 *
 * @author brentmarks
 */
public class Move {
    
    private int x;
    private int y;
    
    public Move(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public boolean equals(Object m){
        return ((Move)m).x == x && ((Move)m).y == y;
    }
    @Override
    public String toString(){
        return "Move [ " + x + ", " + y + " ]";
    }
}
