package checkers;

/**** @author brentmarks*/
/**
 * OVERVIEW: Checkers is an immutable class
 *           Instantiates a User objects, the current user, the Red user and 
 *           the white user and a simpleUI object
 *           The current user checks the whether it is the Red player's turn or 
 *           White player's turn, according to this, the moves are given to the 
 *           corresponding player
 * @author VIDHI PATEL
 */
public class Checkers {
   
    public static User current;
    public static User Red, White;
    public static SimpleUI ui;
    
    /**
     * Effects : Assigns first user to be a red player
     *           Assigns second user to be a white player.
     */
    public static void createUsers(){
        User[] users = ui.createUsers();
        Red = users[0];
        White = users[1];
    }
    
    /**
     * Modifies: Creates the games; initializes a SimpleUI object, an instance of a board, creates users
     *           Asks the user to input the current location and final location of the move
     * Effects: Changes the board as a piece is moved to a different location. 
     */
    public static void Users(){
        ui = new SimpleUI();
        Board b = Board.getInstance();
        b.printBoard();
        createUsers();
        boolean a = true, a1 = true;
        String c = "r";
        
        while(a){
            while(a1){
                current = c.equals("r") ? Red : White; 
                int[] loc = new int[4];
                
                loc = ui.initialLocationInput(b, current.getName(), loc, current.getColor());
                String input3 = ui.skipOption(b, current.getColor(), new Move(loc[0], loc[1]));

                loc = ui.moveInput(b, current.getName(), loc, current.getColor());
                
                if(input3.equals("yes")){
                    a1 = !b.skipPiece(current.getColor(), new Move(loc[0], loc[1]), new Move(loc[2], loc[3]));
                    boolean cont2 = !a1 && b.skip(current.getColor(), new Move(loc[2], loc[3]));
                    while(cont2){
                        //move starting values to account for new starting location
                        loc[0] = loc[2];
                        loc[1] = loc[3];
                        if(!a1 && b.skip(current.getColor(), new Move(loc[0], loc[1]))){
                            String input4 = ui.skipOption(b, current.getColor(), new Move(loc[0], loc[1]));
                            loc = ui.moveInput(b, current.getName(), loc, current.getColor());
                            if(input4.equalsIgnoreCase("yes")){
                                a1 = !b.skipPiece(current.getColor(), new Move(loc[0], loc[1]), new Move(loc[2], loc[3]));
                            }else{
                                a1 = !b.movePiece(current.getColor(), new Move(loc[0], loc[1]), new Move(loc[2], loc[3]));
                                cont2 = false;
                            }
                        }else{
                            cont2 = false;
                        }
                    }
                }else{
                    a1 = !b.movePiece(current.getColor(), new Move(loc[0], loc[1]), new Move(loc[2], loc[3]));
                }
            }
            b.printBoard();
            c = b.flipColor(c);
            a1 = true;
        }
    }
    /**
     * Calls the user object to initiate the game.
     * @param args 
     */
    public static void main(String[] args) {
        Users();
    }
}