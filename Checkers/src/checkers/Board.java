package checkers;

/**** @author brentmarks*/

import java.util.ArrayList;

public class Board
{
    
    private static Board instance = null;
    public Checker[][] pieces = new Checker[8][8];
    
    public static Board getInstance(){
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
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                pieces[i][xw[j + (4 * i)]] = new Checker("r");
                pieces[i + 5][xr[j + (4 * i)]] = new Checker("w");
            }
        }
    }
    public void printBoard(){
        String stuff = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                stuff += pieces[i][j] instanceof Checker ? pieces[i][j].toString() : "-";
            }
            stuff += "\n";
        }
        System.out.println(stuff);
    }
    public boolean movePiece(String color, Move start, Move fin){
        if(!outOfBounds(start, fin) && pieceChecks(start, fin) && moveCheck(pieces[start.getX()][start.getY()], start, fin)){
            pieces[fin.getX()][fin.getY()] = pieces[start.getX()][start.getY()];
            pieces[start.getX()][start.getY()] = null;
        }else{
            System.err.println("Must give a valid move!!!");
            return false;
        }
        return true;
    }
    public boolean skipPiece(String color, Move start, Move fin){
        if(!outOfBounds(start, fin) && pieceChecks(start, fin) && skipCheck(pieces[start.getX()][start.getY()], start, fin)){
            pieces[fin.getX()][fin.getY()] = pieces[start.getX()][start.getY()];
            pieces[start.getX()][start.getY()] = null;
            int h = fin.getY() > start.getY() ? -1 : 1;
            pieces[start.getX() + sideConstant(color)][fin.getY() + h] = null;
        }else{
            System.err.println("Must give a valid move!!!");
            return false;
        }
        return true;
    }
    public boolean outOfBounds(Move start, Move fin){
        boolean neg = start.getX() < 0 || fin.getX() < 0 || start.getY() < 0 ||fin.getY() < 0;
        boolean tooLarge = start.getX() > 7 || fin.getX() > 7 || start.getY() > 7 || fin.getY() > 7;
        return neg || tooLarge;
    }
    public boolean outOfBounds(Move m){
        boolean neg = m.getX() < 0 || m.getY() < 0;
        boolean tooLarge = m.getX() > 7 || m.getY() > 7;
        return neg || tooLarge;
    }
    public boolean pieceChecks(Move start, Move fin){
        boolean originalSpotFilled = pieces[start.getX()][start.getY()] != null;
        boolean finalSpotFilled = pieces[fin.getX()][fin.getY()] != null;
        return !finalSpotFilled && originalSpotFilled;
    }
    public boolean moveCheck(Checker c, Move start, Move fin){
        ArrayList<Move> moves = c.getMoves("move", start);
        return moves.contains(fin);
    }
    public boolean skipCheck(Checker c, Move start){
        ArrayList<Move> moves = c.getMoves("skip", start);
        for (Move m: moves){
            if(m.getX() >= 0 && m.getY() >= 0){
                Checker tmp1 = pieces[m.getX()][m.getY()];
                if(tmp1 == null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean skipCheck(Checker c, Move start, Move fin){
        ArrayList<Move> moves = c.getMoves("skip", start);
        return moves.contains(fin);
    }
    public boolean skip(String color, int x1, int y1){//dont change x1, y1 it doesnt seem to work whe change will look at later
        int tmpM = x1 + sideConstant(color);
        int tmpYM_1 = y1 + 1;
        int tmpYM_2 = y1 - 1;
        boolean canSkip1 = false, canSkip2 = false;
        if(tmpM >= 0 && tmpYM_1 >= 0){
            Checker tmp1 = pieces[tmpM][tmpYM_1];
            canSkip1 = tmp1 != null && tmp1.getColor().equals(flipColor(color));
        }
        if(tmpM >= 0 && tmpYM_2 >= 0){
            Checker tmp2 = pieces[tmpM][tmpYM_2];
            canSkip2 = tmp2 != null && tmp2.getColor().equals(flipColor(color));
        }
        return (canSkip1 || canSkip2) && skipCheck(pieces[x1][y1], new Move(x1, y1));
    }
    public String flipColor(String color){
        return color.equals("w") ? "r" : "w";
    }
    public int sideConstant(String color){//rename later
        return color.equals("w") ? -1 : 1;
    }
    @Override
    public String toString(){
        return "";//equivalent to printBoard() method
    }
}