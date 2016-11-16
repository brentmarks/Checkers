package checkers;

/*
*
*
* @author brent marks 
*/

import java.util.ArrayList;

public class Checker {
    private String color;
    private boolean king;
    
    public Checker(String color){
        this.color = color.toLowerCase();
    }
    
    //add in logic to for converting piece into king when reach the other side of the board
    //turns the piece into a king piece
    //Checks if the a piece is on the other side and changes to king
    public void kingMe(Move fin){
        if(color.equals("w") && fin.getX() == 0){
            king = true;
            color = color.toUpperCase();
        }else if(color.equals("r") && fin.getX() == 7){
            king = true;
            color = color.toUpperCase();
        }
    }
    public boolean isKing(){
        return king;
    }
    public String getColor(){
        return color;
    }
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
    public int sideConstant(String color){//rename later
        return color.equals("w") ? -1 : 1;
    }
    @Override
    public String toString(){
        return color;
    }
}