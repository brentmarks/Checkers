package checkers;

/**** @author brentmarks */

import java.util.ArrayList;

public class Checker 
{
    private String color;
    private boolean king;
    
    public Checker(String color){
        this.color = color.toLowerCase();
    }
    //add in logic to for converting piece into king when reach the other side of the board
    //turns the piece into a king piece
    public void kingMe(){
        king = true;
        color = color.toUpperCase();
    }
    public boolean isKing(){
        return king;
    }
    public String getColor(){
        return color;
    }
    public void movePiece(){
        
    }
    public ArrayList<Move> getMoves(String type, Move start){//type = "move" or "skip"
        ArrayList<Move> moves = new ArrayList<Move>();
        if(!king){
            if(type.equals("move")){
                moves.add(new Move(start.getX() + sideConstant(color), start.getY() + 1));//possible move 1
                moves.add(new Move(start.getX() + sideConstant(color), start.getY() - 1));//possible move 2
            }else if(type.equals("skip")){
                moves.add(new Move(start.getX() + sideConstant(color)*2, start.getY() + 2));//possible move 1
                moves.add(new Move(start.getX() + sideConstant(color)*2, start.getY() - 2));//possible move 2
            }else{
                System.err.println("WRONG");//insert trump gif
                return null;
            }
        }else{
            //king should have 4 moves
            return null;
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