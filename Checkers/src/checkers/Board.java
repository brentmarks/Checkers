package checkers;

/**
 * ** @author brent marks, v. patel
 */
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
    public boolean outOfBounds(Move start, Move fin) {
        boolean neg = start.getX() < 0 || fin.getX() < 0 || start.getY() < 0 || fin.getY() < 0;
        boolean tooLarge = start.getX() > 7 || fin.getX() > 7 || start.getY() > 7 || fin.getY() > 7;
        return neg || tooLarge;
    }
    public boolean outOfBounds(Move m) {
        boolean neg = m.getX() < 0 || m.getY() < 0;
        boolean tooLarge = m.getX() > 7 || m.getY() > 7;
        return neg || tooLarge;
    }
    public boolean pieceChecks(Move start, Move fin) {
        //checks the original spot that the user has given to make sure it is filled with an actual checker
        boolean originalSpotFilled = getPiece(start.getX(), start.getY()) != null;
        //checks the final spot of that the user has given to make sure it is empty
        boolean finalSpotFilled = getPiece(fin.getX(), fin.getY()) != null; 
        return !finalSpotFilled && originalSpotFilled;
    }
    public boolean moveCheck(Checker c, Move start, Move fin) {
        ArrayList<Move> moves = c.getMoves("move", start);
        return moves.contains(fin);
    }
    public boolean skipCheck(Checker c, Move start) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            if (moves.stream().anyMatch((m) -> (!outOfBounds(m) && getPiece(m.getX(), m.getY()) == null))) {//checks the piece after the piece it is going to skip to make sure it is empty
                return true;
            } 
        }
        return false;
    }
    public boolean skipCheck(Checker c, Move start, Move fin) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            Move m = moves.get(moves.indexOf(fin));
            boolean good = m != null && getPiece(m.getX(), m.getY()) == null;
            return moves.contains(fin) && good;
        }
        return false;
    }
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
    public String flipColor(String color) {
        return color.equals("w") ? "r" : "w";
    }
    public Checker getPiece(int x, int y) {
        if (!outOfBounds(new Move(x, y))) {
            return pieces[x][y];
        }
        return null;
    }
    public int sideConstant(String color) {//rename later
        return color.equals("w") ? -1 : 1;
    }
    @Override
    public String toString() {
        return "";//equivalent to printBoard() method
    }
}
