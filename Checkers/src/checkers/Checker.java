package checkers;

/**** @author brentmarks */

public class Checker 
{
    private String color;
    private boolean king;
    
    public Checker(String color)
    {
        this.color = color.toLowerCase();
    }
    
    //add in logic to for converting piece into king when reach the other side of the board
    //turns the piece into a king piece
    public void kingMe()
    {
        king = true;
        color = color.toUpperCase();
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString()
    {
        return color;
    }
}