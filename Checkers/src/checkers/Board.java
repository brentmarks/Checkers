package checkers;

/**** @author brentmarks*/

public class Board
{
    
    private static Board instance = null;
    public Checker[][] pieces = new Checker[8][8];
    
    public static Board getInstance()
    {
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }
    
    private Board(){
        setupBoard();
    }
    private void setupBoard(){
        int[] xr = { 0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6 };
        int[] xw = { 1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7 };
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                pieces[i][xw[j + (4 * i)]] = new Checker("r");
                pieces[i + 5][xr[j + (4 * i)]] = new Checker("w");
            }
        }
    }
    public void printBoard(){
        String stuff = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(pieces[i][j] != null){
                    stuff += pieces[i][j].toString();
                }else{
                    stuff += "-";
                }
            }
            stuff += "\n";
        }
        System.out.println(stuff);
    }
    public boolean movePiece(String color, int x1, int y1, int x2, int y2){
        if(!outOfBounds(x1, y1, x2, y2) && pieceChecks(x1, y1, x2, y2) && moveCheck(color, x1, y1, x2, y2)){
            pieces[x2][y2] = pieces[x1][y1];
            pieces[x1][y1] = null;
        }else{
            System.err.println("Must give a valid move!!! OOB: " + outOfBounds(x1, y1, x2, y2) + " PC: " + pieceChecks(x1, y1, x2, y2) + " MC: " + moveCheck(color, x1, y1, x2, y2));
            return false;
        }
        return true;
    }
    public boolean skipPiece(String color, int x1, int y1, int x2, int y2){
        if(!outOfBounds(x1, y1, x2, y2) && pieceChecks(x1, y1, x2, y2) && skipCheck(color, x1, y1, x2, y2))
        {
            int redWhite = color.equals("w") ? -1 : 1;
            pieces[x2][y2] = pieces[x1][y1];
            pieces[x1][y1] = null;
            int h = y2 > y1 ? -1 : 1;
            System.out.println("h: " + h + " " + (x2 + redWhite) + " " +  (y2 + h));
            pieces[x1 + redWhite][y2 + h] = null;
        }else{
            System.err.println("Must give a valid move!!! OOB: " + outOfBounds(x1, y1, x2, y2) + " PC: " + pieceChecks(x1, y1, x2, y2) + " MC: " + moveCheck(color, x1, y1, x2, y2));
            return false;
        }
        return true;
    }
    public boolean outOfBounds(int x1, int y1, int x2, int y2){
        boolean neg = x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0;
        boolean tooLarge = x1 > 7 || x2 > 7 || y1 > 7 || y2 > 7;
        return neg || tooLarge;
    }
    public boolean pieceChecks(int x1, int y1, int x2, int y2){
        boolean originalSpotFilled = pieces[x1][y1] != null;
        boolean finalSpotFilled = pieces[x2][y2] != null;
        return !finalSpotFilled && originalSpotFilled;
    }
    public boolean moveCheck(String color, int x1, int y1, int x2, int y2){
        int redWhite = color.equals("w") ? -1 : 1;
        int tmpX2 = x1 + redWhite;
        int tmpY2_1 = y1 + 1;
        int tmpY2_2 = y1 - 1;
        boolean correctX2 = tmpX2 == x2;
        boolean correctY2 = tmpY2_1 == y2 || tmpY2_2 == y2;
        return correctX2 && correctY2;
    }
    public boolean skipCheck(String color, int x1, int y1){
        boolean good1 = false, good2 = false;
        int redWhite = color.equals("w") ? -2 : 2;
        int tmpX2 = x1 + redWhite;
        int tmpY2_1 = y1 + 2;
        int tmpY2_2 = y1 - 2;
        if(tmpX2 >= 0 && tmpY2_1 >= 0){
            Checker tmp1 = pieces[tmpX2][tmpY2_1];
            good1 = tmp1 == null;
        }
        if(tmpX2 >= 0 && tmpY2_2 >= 0){
            Checker tmp2 = pieces[tmpX2][tmpY2_2];
            good2 = tmp2 == null;
        }
        return good1 || good2;
    }
    public boolean skipCheck(String color, int x1, int y1, int x2, int y2){
        int redWhite = color.equals("w") ? -2 : 2;
        int tmpX2 = x1 + redWhite;
        int tmpY2_1 = y1 + 2;
        int tmpY2_2 = y1 - 2;
        boolean correctX2 = tmpX2 == x2;
        boolean correctY2 = tmpY2_1 == y2 || tmpY2_2 == y2;
        return correctX2 && correctY2;
    }
    public boolean skip(String color, int x1, int y1){
        int redWhite = color.equals("w") ? -1 : 1;
        int tmpX2 = x1 + redWhite;
        int tmpY2_1 = y1 + 1;
        int tmpY2_2 = y1 - 1;
        boolean canSkip1 = false, canSkip2 = false;
        if(tmpY2_1 >= 0){
            Checker tmp1 = pieces[tmpX2][tmpY2_1];
            canSkip1 = tmp1 != null && tmp1.getColor().equals(flipColor(color));
            //System.out.println("g "+ canSkip1 + " " + tmpY2_2);
        }
        if(tmpY2_2 >= 0){
            Checker tmp2 = pieces[tmpX2][tmpY2_2];
            canSkip2 = tmp2 != null && tmp2.getColor().equals(flipColor(color));
        }
        return (canSkip1 || canSkip2) && skipCheck(color, x1, y1);
    }
    public String flipColor(String color){
        return color.equals("w") ? "r" : "w";
    }
}