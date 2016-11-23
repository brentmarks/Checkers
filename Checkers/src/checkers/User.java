package checkers;

/** 
 * @author Brent Marks
 * @author Vruti Vaghela
 * @author Vidhi Patel
 **/

/**
 * OVERVIEW: Creates user object with a name and color (either red or white). 
 */

public class User {
    
    private final String color;
    private final String name;
    
    /**
     * Creates an User object with a color (red or white) and name of the user
     * @param color
     * @param name 
     */
    public User(String color, String name){
        this.color = color;
        this.name = name;
    }
    
    /**
     * @return the color of piece that the user represents 
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * @return name of the user
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * @return the user name and color as a string object
     */
    @Override
    public String toString(){
        return "User [ Name: " + name + ", Color: " + color + " ]";
    }
}