package checkers;

/**
 *
 * @author brentmarks
*/

import java.util.Scanner;

public class SimpleUI {
    private static Scanner sc = new Scanner(System.in);
    
    public String skipOption(Board b, String color, Move start){
        if(b.skip(color, start)){
            System.out.println("Would you like to skip or move piece? (yes/no)");
            String input = sc.nextLine();
            return input;
        }
        return "";
    }
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
}