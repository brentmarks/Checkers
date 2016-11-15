package checkers;

/**
 * ** @author brentmarks
 */
import java.util.ArrayList;

public class Board {

    //check to make sure if at 7 dont go out of bounds
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
        /*int[] xr = { 0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6 };
        int[] xw = { 1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7 };
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                pieces[i][xw[j + (4 * i)]] = new Checker("r");
                pieces[i + 5][xr[j + (4 * i)]] = new Checker("w");
            }
        }*/
        pieces[0][1] = new Checker("w");
        pieces[0][1].kingMe(new Move(0, 1));
        pieces[1][2] = new Checker("r");
        pieces[0][5] = new Checker("r");
        pieces[2][3] = new Checker("w");
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
            System.out.println(h);
            System.out.println("x: " + (start.getX() + dir) + " Y: " + (fin.getY() + h));
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
        boolean originalSpotFilled = pieces[start.getX()][start.getY()] != null;
        boolean finalSpotFilled = pieces[fin.getX()][fin.getY()] != null;
        return !finalSpotFilled && originalSpotFilled;
    }

    public boolean moveCheck(Checker c, Move start, Move fin) {
        ArrayList<Move> moves = c.getMoves("move", start);
        return moves.contains(fin);
    }

    public boolean skipCheck(Checker c, Move start) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            for (Move m : moves) {
                if (m.getX() >= 0 && m.getY() >= 0 && m.getX() <= 7 && m.getY() <= 7) {
                    Checker tmp1 = pieces[m.getX()][m.getY()];
                    if (tmp1 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean skipCheck(Checker c, Move start, Move fin) {
        if (c != null) {
            ArrayList<Move> moves = c.getMoves("skip", start);
            System.out.println(moves);
            return moves.contains(fin);
        }
        return false;
    }

    public boolean skip(String color, Move start) {//dont change x1, y1 it doesnt seem to work whe change will look at later
        Move[] norm = {new Move(start.getX() + sideConstant(color), start.getY() + 1), new Move(start.getX() + sideConstant(color), start.getY() - 1)};
        Move[] king = {new Move(start.getX() + sideConstant(color), start.getY() + 1), new Move(start.getX() + sideConstant(color), start.getY() - 1),
                       new Move(start.getX() - sideConstant(color), start.getY() + 1), new Move(start.getX() - sideConstant(color), start.getY() - 1)};
        Checker c = getPiece(start.getX(), start.getY());
        if (c != null && !outOfBounds(start) && color.equalsIgnoreCase(c.getColor())) {
            System.out.println("got here 1");
            Move[] moves = c.isKing() ? king : norm;
            //System.out.println(norm +" \n" + king);
            for (Move m : moves) {
                if (!outOfBounds(m)) {
                    Checker tmp = pieces[m.getX()][m.getY()];
                    System.out.println("got here");
                    if(tmp != null && tmp.getColor().equals(flipColor(color)) && skipCheck(getPiece(start.getX(), start.getY()), start)){
                        System.out.println("HERE!");
                        return true;
                    }
                }
            }
        }
        return false;
        /*
            //int tmpM = start.getX() + sideConstant(color);
            //int tmpYM_1 = start.getY() + 1;
            //int tmpYM_2 = start.getY() - 1;
            boolean canSkip1 = false, canSkip2 = false;
            if (!outOfBounds(start) && color.equals(pieces[start.getX()][start.getY()].getColor())) {
                if (tmpM >= 0 && tmpYM_1 >= 0 && tmpM <= 7 && tmpYM_1 <= 7) {
                    Checker tmp1 = pieces[tmpM][tmpYM_1];
                    canSkip1 = tmp1 != null && tmp1.getColor().equals(flipColor(color));
                }
                if (tmpM >= 0 && tmpYM_2 >= 0 && tmpM <= 7 && tmpYM_2 <= 7) {
                    Checker tmp2 = pieces[tmpM][tmpYM_2];
                    canSkip2 = tmp2 != null && tmp2.getColor().equals(flipColor(color));
                }
                return (canSkip1 || canSkip2) && skipCheck(getPiece(start.getX(), start.getY()), start);
            }
        }
        return false;*/
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
