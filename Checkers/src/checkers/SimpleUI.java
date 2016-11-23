package checkers;

/**
 * @author Brent Marks
 * @author Vruti Vaghela
 * @author Vidhi Patel
**/

/**
 * OVERVIEW: Instantiates a scanner object which takes in the current location 
 *           of the piece, the final location of the piece and if a skip is possible 
 *           the option is then takes user's decision.
 */

import java.util.Scanner;

public class SimpleUI {
    
    private static final Scanner sc = new Scanner(System.in);
    /**
     * Requires: The instance of the board, the color of the player and the starting location
     * Effects: If a piece can be skipped, the user is asked if they want to skip over the piece. 
     * @param b
     * @param color
     * @param start
     * @return 
     */
    public String skipOption(Board b, String color, Move start){
        if(b.skip(color, start)){
            System.out.println("Would you like to skip this piece enter yes of no? (yes/no)");
            String input = sc.nextLine();
            return input;
        }
        return "";
    }
    /**
     * Requires: Current location of the piece 
     * Modifies: The array of locations to the user input location.
     * @param b
     * @param name
     * @param loc
     * @param color
     * @return the new integer array of the current location.
     */
    public int[] initialLocationInput(Board b, String name, int[] loc, String color){
        boolean cont = true, cont1 = false;
        while(cont){
            cont1 = false;
            System.out.println(name + " please enter: original location of piece row col");
            String input = sc.nextLine();
            String[] slots = input.split(" ");
            for(int i = 0; i < 2; i++){
                try{
                    loc[i] = Integer.parseInt(slots[i]);// -1 after to adjust for starting at zero
                }catch(Exception e){
                    cont1 = true;
                    break;
                }
            }
            if(!b.outOfBounds(new Move(loc[0], loc[1])) && b.getPiece(loc[0], loc[1]) != null && b.getPiece(loc[0], loc[1]).getColor().equalsIgnoreCase(color)){
                cont = cont1;
            }else{
                System.err.println("Please enter valid move!!");
            }
        }
        return loc;
    }
    /**
     * Requires: Final location of the piece 
     * Modifies: The array of locations to the user final location, add to the array of input locations.
     * @param b
     * @param name
     * @param loc
     * @param color
     * @return 
     */
    public int[] moveInput(Board b, String name, int[] loc, String color){
        boolean cont = true, cont1 = false;
        while(cont){
            cont1 = false;
            System.out.println(name + " please enter: final location of piece you would like to move row col.");
            String input1 = sc.nextLine();
            String[] slots2 = input1.split(" ");
            for(int i = 0; i < 2; i++){
                try{
                    loc[i + 2] = Integer.parseInt(slots2[i]);// -1 after to adjust for starting at zero
                }catch(Exception e){
                    cont1 = true;
                    break;
                }
            }
            if(!b.outOfBounds(new Move(loc[0], loc[1])) && b.getPiece(loc[0], loc[1]) != null && b.getPiece(loc[0], loc[1]).getColor().equalsIgnoreCase(color)){
                cont = cont1;
            }else{
                System.err.println("Please enter a proper move!!");
            }
        }
        return loc;
    }
    
    /**
     * Requires: The names of the players
     * Effects: Sets user 1 to be red and user 2 to be white
     * @return the array of 2 users
     */
    public User[] createUsers(){
        User[] users = new User[2];
        System.out.println("Please enter your name for player red:");
        String red = sc.nextLine();
        users[0] = new User("r", red);
        System.out.println("Please enter your name for player white:");
        String white = sc.nextLine();
        users[1] = new User("w", white);
        return users;
    }
    
    public void gameOver(User winner){
        System.out.println("Congratulations " + winner.getName() + " you have won the game.");
    }
}