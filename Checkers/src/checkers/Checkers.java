package checkers;

import java.util.Scanner;

/**** @author brentmarks*/

public class Checkers 
{
    
    private static final Scanner sc = new Scanner(System.in);
    public static User current;
    public static User Red;
    public static User White;
    
    public static int[] initialLocationInput(int[] loc){
        boolean cont = true, cont1 = false;
        while(cont){
            cont1 = false;
            System.out.println(current.getName() + " please enter: original location of piece row col");
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
            cont = cont1;
        }
        return loc;
    }
    public static int[] moveInput(int[] loc){
        boolean cont = true, cont1 = false;
        while(cont){
            cont1 = false;
            System.out.println(current.getName() + " please enter: final location of piece you would like to move row col.");
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
            cont = cont1;
        }
        return loc;
    }
    public static void createUsers(){
        System.out.println("Please enter your name for player red:");
        String red = sc.nextLine();
        Red = new User("r", red);
        System.out.println("Please enter your name for player white:");
        String white = sc.nextLine();
        White = new User("w", white);
    }
    public static String skipOption(Board b, int x1, int y1){
        if(b.skip(current.getColor(), x1, y1)){
            System.out.println("Would you like to skip or move piece? (yes/no)");
            String input = sc.nextLine();
            return input;
        }
        return "";
    }
    
    public static void main(String[] args) 
    {
        Board b = Board.getInstance();
        b.printBoard();
        createUsers();
        boolean a = true, a1 = true;
        String c = "r";
        
        while(a)
        {
            while(a1)
            {
                current = c.equals("r") ? Red : White; 
                int[] loc = new int[4];
                
                loc = initialLocationInput(loc);
                String input3 = skipOption(b, loc[0], loc[1]);//System.out.println("Skip: " + b.skip(current.getColor(), loc[0], loc[1]));

                loc = moveInput(loc);
                
                if(input3.equals("yes")){
                    a1 = !b.skipPiece(current.getColor(), loc[0], loc[1], loc[2], loc[3]);
                    boolean cont2 = !a1 && b.skip(current.getColor(), loc[2], loc[3]);
                    while(cont2)
                    {
                        //move starting values to account for new starting location
                        loc[0] = loc[2];
                        loc[1] = loc[3];
                        if(!a1 && b.skip(current.getColor(), loc[0], loc[1])){
                            String input4 = skipOption(b, loc[0], loc[1]);
                            loc = moveInput(loc);
                            if(input4.equals("yes")){
                                a1 = !b.skipPiece(current.getColor(), loc[0], loc[1], loc[2], loc[3]);
                            }else{
                                a1 = !b.movePiece(current.getColor(), loc[0], loc[1], loc[2], loc[3]);
                                cont2 = false;
                            }
                        }else{
                            cont2 = false;
                        }
                    }
                }else{
                    a1 = !b.movePiece(current.getColor(), loc[0], loc[1], loc[2], loc[3]);
                }
                System.out.println(loc[0] + " " + loc[1] + " " + loc[2] + " " + loc[3]);
                
            }
            b.printBoard();
            c = b.flipColor(c);//System.out.println(c);
            a1 = true;
        }
    }
}