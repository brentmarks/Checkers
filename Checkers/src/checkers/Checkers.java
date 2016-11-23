package checkers;

/** 
 * @author Brent Marks
 * @author Vruti Vaghela
 * @author Vidhi Patel
**/

public class Checkers {
   
    public static User current;
    public static User Red, White;
    public static SimpleUI ui;
    public static int redNum, whiteNum;
    
    public static void createUsers(){
        User[] users = ui.createUsers();
        Red = users[0];
        White = users[1];
    }
    
    public static boolean FinishGame(Board b){
        Checker[][] pieces = b.getPieces();
        redNum = 0;
        whiteNum = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(redNum == 0 || whiteNum == 0){
                    if(pieces[i][j] instanceof Checker){
                        if(pieces[i][j].getColor().equalsIgnoreCase("w")){
                            whiteNum++;
                        }else{
                            redNum++;
                        }
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void Game(){
        ui = new SimpleUI();
        Board b = Board.getInstance();
        b.printBoard();
        createUsers();
        boolean a = true, a1 = true;
        String c = "r";
        
        while(a){
            while(a1){
                current = c.equalsIgnoreCase("r") ? Red : White; 
                int[] loc = new int[4];
                
                loc = ui.initialLocationInput(b, current.getName(), loc, current.getColor());
                String input3 = ui.skipOption(b, current.getColor(), new Move(loc[0], loc[1]));

                loc = ui.moveInput(b, current.getName(), loc, current.getColor());
                
                if(input3.equalsIgnoreCase("yes")){
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
            if(FinishGame(b)){
                break;
            }
        }
        ui.gameOver(redNum > whiteNum ? Red : White);// finish the game
    }
    
    public static void main(String[] args) {
        Game();
    }
}