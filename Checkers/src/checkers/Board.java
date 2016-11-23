package checkers;

/**
 * @author Brent Marks
 * @author Vruti Vaghela
 * @author Vidhi Patel
**/
import java.util.ArrayList;

public class Board {

    private static Board instance = null;
    public Checker[][] pieces = new Checker[8][8];

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    /**
     * creates an instance of the board.
     */
    private Board() {
        setupBoard();
    }
    private void setupBoard() {
        int[] xr = { 0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6 };
        int[] xw = { 1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7 };
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                pieces[i][xw[j + (4 * i)]] = new Checker("r");
                pieces[i + 5][xr[j + (4 * i)]] = new Checker("w");
            }
        }
        //pieces[0][1] = new Checker("w");
        //pieces[0][1].kingMe(new Move(0, 1));
        //pieces[1][2] = new Checker("r");
        //pieces[0][5] = new Checker("r");
    }
    /**
     * creates a board that is 8 by 8 grid long.
     */
    public void printBoard() {
        String stuff = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stuff += pieces[i][j] instanceof Checker ? pieces[i][j].toString() : "-";
            }
            stuff += "\n";
        }
        System.out.println(stuff);
    }
    /**
     * Require: The start location, final location to be within the bounds
     * Modifies: The location of the piece if the skip is possible
     * Effects: Checks if the piece can move to the final location
     *          If the piece reaches the other end the board, it becomes a king. 
     * @param color
     * @param start
     * @param fin
     * @return true if the move is possible else returns false. 
    */
    public boolean movePiece(String color, Move start, Move fin) {
        if (!outOfBounds(start, fin) && pieceChecks(start, fin) && moveCheck(pieces[start.getX()][start.getY()], start, fin)) {
            pieces[fin.getX()][fin.getY()] = pieces[start.getX()][start.getY()];
            pieces[start.getX()][start.getY()] = null;
            pieces[fin.getX()][fin.getY()].kingMe(fin);
        } else {
            System.err.println("Must give a valid move!!!");
            return false;
        }
        return true;
    }
    /**
     * /**
     * Require: The start and fin objects to be within the bounds
     * Modifies: If the piece reaches the other end the board, it becomes a king
     * Effects: Checks if the piece can skip a piece of opposite color and move to the final location
     *          Returns true if the skip is possible otherwise false.
     * @param color
     * @param start
     * @param fin
     * @return true if the skip is possible else returns false.
     */
    public boolean skipPiece(String color, Move start, Move fin) {
        if (!outOfBounds(start, fin) && pieceChecks(start, fin) && skipCheck(pieces[start.getX()][start.getY()], start, fin)) {
            pieces[fin.getX()][fin.getY()] = pieces[start.getX()][start.getY()];
            pieces[start.getX()][start.getY()] = null;
            int h = fin.getY() > start.getY() ? -1 : 1;
            int dir = pieces[fin.getX()][fin.getY()].isKing() ? h*(-1) : sideConstant(color);
            pieces[start.getX() + dir][fin.getY() + h] = null;
            pieces[fin.getX()][fin.getY()].kingMe(fin);
        } else {
            System.err.println("Must give a valid move!!!");
            return false;
        }
        return true;
    }
    /**
     * Effects: Checks if the locations are beyond the board size 
     * @param start
     * @param fin
     * @return true if the final location is not out of Bounds.
     */
    public boolean outOfBounds(Move start, Move fin) {
        boolean neg = start.getX() < 0 || fin.getX() < 0 || start.getY() < 0 || fin.getY() < 0;
        boolean tooLarge = start.getX() > 7 || fin.getX() > 7 || start.getY() > 7 || fin.getY() > 7;
        return neg || tooLarge;
    }
    /**
     * Effects: Checks if the location is beyond the board size 
     * @param m
     * @return true if the final location is not out of Bounds.
     */
    public boolean outOfBounds(Move m) {
        boolean neg = m.getX() < 0 || m.getY() < 0;
        boolean tooLarge = m.getX() > 7 || m.getY() > 7;
        return neg || tooLarge;
    }
    
    /**
     * Requires: Starting location and final location; these are Move objects within the bounds
     * Effects: Checks if there is a checker piece at that location and if the final location is empty 
     * @param start
     * @param fin
     * @return true is the final spot is empty and there is a checker piece at the starting location
     */
    public boolean pieceChecks(Move start, Move fin) {
        //checks the original spot that the user has given to make sure it is filled with an actual checker
        boolean originalSpotFilled = getPiece(start.getX(), start.getY()) != null;
        //checks the final spot of that the user has given to make sure it is empty
        boolean finalSpotFilled = getPiece(fin.getX(), fin.getY()) != null; 
        return !finalSpotFilled && originalSpotFilled;
    }
    
    /**
     * Requires: The starting location and the final location to be within the bounds
     * Modifies: An arrayList of Move objects
     * Effects:  Returns true if the final location is inside the arrayList of Move objects,
     *           otherwise returns false.
     * @param c
     * @param start
     * @param fin
     * @return 
     */
    public boolean moveCheck(Checker c, Move start, Move fin) {
        ArrayList<Move> moves = c.getMoves("move", start);
        return moves.contains(fin);
    }
    
    /**
     * Requires: The starting object is within the bounds
     * Effects:  Returns true if the final location after skip is empty, otherwise returns false.
     * @param c
     * @param start
     * @return 
     */
    public boolean skipCheck(Checker c, Move start) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            if (moves.stream().anyMatch((m) -> (!outOfBounds(m) && getPiece(m.getX(), m.getY()) == null))) {//checks the piece after the piece it is going to skip to make sure it is empty
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Requires: The starting and final move objects is within the bounds
     * Effects:  Returns true if the final location after skip is empty, otherwise returns false.
     * @param c
     * @param start
     * @param fin
     * @return 
     */
    public boolean skipCheck(Checker c, Move start, Move fin) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            Move m = moves.get(moves.indexOf(fin));
            boolean good = m != null && getPiece(m.getX(), m.getY()) == null;
            return moves.contains(fin) && good;
        }
        return false;
    }
    
    /**
     * /**
     * Requires: The starting object is within the bounds
     * Effects:  checks array of normal checkers or if the piece is a king then checks the array of the king
     *           If the checker piece is in the bounds, then a temp piece is created
     *           Returns true if the the temp piece is not null and the piece to be skipped is opposite color,
     *           else returns false.
     * @param color
     * @param start
     * @return 
     */
    public boolean skip(String color, Move start) {
        Move[] norm = {new Move(start.getX() + sideConstant(color), start.getY() + 1), new Move(start.getX() + sideConstant(color), start.getY() - 1)};
        Move[] king = {new Move(start.getX() + sideConstant(color), start.getY() + 1), new Move(start.getX() + sideConstant(color), start.getY() - 1),
                       new Move(start.getX() - sideConstant(color), start.getY() + 1), new Move(start.getX() - sideConstant(color), start.getY() - 1)};
        Checker c = getPiece(start.getX(), start.getY());
        if (c != null && !outOfBounds(start) && color.equalsIgnoreCase(c.getColor())) {
            Move[] moves = c.isKing() ? king : norm;
            for (Move m : moves) {
                if (!outOfBounds(m)) {
                    Checker tmp = pieces[m.getX()][m.getY()];
                    if(tmp != null && tmp.getColor().equals(flipColor(color)) && skipCheck(getPiece(start.getX(), start.getY()), start)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Requires: The color is either red('r') or white ('w')
     * Effects: returns the opposite color as a string.
     * @param color
     * @return 
     */
    public String flipColor(String color) {
        return color.equals("w") ? "r" : "w";
    }
    
    /**
     * Requires: The indexes to be within the bounds
     * Effects: The checker piece at that location
     * @param x
     * @param y
     * @return 
     */
    public Checker getPiece(int x, int y) {
        if (!outOfBounds(new Move(x, y))) {
            return pieces[x][y];
        }
        return null;
    }
    /**
     * 
     * @param color
     * @return 
     */
    public int sideConstant(String color) {//rename later
        return color.equals("w") ? -1 : 1;
    }
    @Override
    public String toString() {
        return "";//equivalent to printBoard() method
    }
}
