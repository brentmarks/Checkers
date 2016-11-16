package checkers;

/**** @author brentmarks*/

public class User {
    
    private String color;
    private String name;
    
    public User(String color, String name){
        this.color = color;
        this.name = name;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return "User [ Name: " + name + ", Color: " + color + " ]";
    }
}