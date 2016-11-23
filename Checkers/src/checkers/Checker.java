 package checkers;

/**
* @author brent marks 
* @author Vruti Vaghela
* @author Vidhi Patel
**/

import java.util.ArrayList;

public class Checker {
    private String color;
    private boolean king;
    
    public Checker(String color){
        this.color = color.toLowerCase();
    }
    
/**
 * Requires: The final location of the piece
 * Modifies: Characteristics of the piece change when a piece reaches the other side of the board
 * Effects: The letter of the color is capitalized.
 * @param fin 
 */    
    public void kingMe(Move fin){
        if(color.equals("w") && fin.getX() == 0){
            king = true;
            color = color.toUpperCase();
        }else if(color.equals("r") && fin.getX() == 7){
            king = true;
            color = color.toUpperCase();
        }
    }
    /**
     * @return if the piece is a king
     */
    public boolean isKing(){
        return king;
    }
    /**
     * @return the color of the piece
     */
    public String getColor(){
        return color;
    }
    /**
     * Requires: The type of move, "move" or "skip" and the starting location of the piece within the board
     * Modifies: The arrayList of moves for each type of pieces
     * Effects: If the piece is a king, then it can move to 4 different location, 
     *          Otherwise, the piece can move in two directions.
     * @param type
     * @param start
     * @return ArrayList of possible moves for the type of piece
     */
    //returns an arraylist of possible moves that are legal
    public ArrayList<Move> getMoves(String type, Move start){//type = "move" or "skip"
        ArrayList<Move> moves = new ArrayList<>();
        if(king){
             switch (type) {
                    case "move":
                        moves.add(new Move(start.getX() + sideConstant(color), start.getY() + 1));//possible move 1
                        moves.add(new Move(start.getX() + sideConstant(color), start.getY() - 1));//possible move 2
                        moves.add(new Move(start.getX() - sideConstant(color), start.getY() + 1));//possible move 3
                        moves.add(new Move(start.getX() - sideConstant(color), start.getY() - 1));//possible move 4
                        break;
                    case "skip":
                        moves.add(new Move(start.getX() + sideConstant(color) * 2, start.getY() + 2));//possible move 1
                        moves.add(new Move(start.getX() + sideConstant(color) * 2, start.getY() - 2));//possible move 2
                        moves.add(new Move(start.getX() - sideConstant(color) *2, start.getY() + 2));//possible move 3
                        moves.add(new Move(start.getX() - sideConstant(color) * 2, start.getY() - 2));//possible move 4
                        break;
                    default:
                        System.err.println("WRONG");
                        return null;
                }
        }else{
            switch (type) {
                case "move":
                    moves.add(new Move(start.getX() + sideConstant(color), start.getY() + 1));//possible move 1
                    moves.add(new Move(start.getX() + sideConstant(color), start.getY() - 1));//possible move 2
                    break;
                case "skip":
                    moves.add(new Move(start.getX() + sideConstant(color)*2, start.getY() + 2));//possible move 1
                    moves.add(new Move(start.getX() + sideConstant(color)*2, start.getY() - 2));//possible move 2
                    break;
                default:
                    System.err.println("WRONG");//insert trump gif
                    return null;
            }
            
        }
        return moves;
    }
    /**
     * Requires: The color of the piece; either red or white
     * Effects : if the color is white it returns -1 or 1 if the color is red 
     * @param color
     * @return either 1 or -1 depending on the color
     */
    public int sideConstant(String color){//rename later
        return color.equals("w") ? -1 : 1;
    }
    
    /**
     * @return the color of the piece
     */
    @Override
    public String toString(){
        return color;
    }
}