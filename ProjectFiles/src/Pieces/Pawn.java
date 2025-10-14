package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Pawn extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'P';

    public Pawn(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> possibleMoves = new ArrayList<>();
        if(color.color == 'B'){
            if(position.row + 1 < 8){
                if(board.getPiece(new Position(this.position.row + 1, this.position.col)) != null)possibleMoves.add(new Position(position.row + 1, position.col));
                Position takeLeft =  new Position(position.row + 1, position.col + 1);
                if(board.getPiece(takeLeft) != null && board.getPiece(takeLeft).getColor() != 'B')possibleMoves.add(takeLeft);
                Position takeRight =  new Position(position.row + 1, position.col - 1);
                if(board.getPiece(takeRight) != null && board.getPiece(takeRight).getColor() != 'B')possibleMoves.add(takeRight);
            }
        }
        else{
            if(position.row - 1 > -1){
                if(board.getPiece(new Position(this.position.row + 1, this.position.col)) != null)possibleMoves.add(new Position(position.row - 1, position.col));
                Position takeLeft =  new Position(position.row - 1, position.col + 1);
                if(board.getPiece(takeLeft) != null && board.getPiece(takeLeft).getColor() != 'W')possibleMoves.add(takeLeft);
                Position takeRight =  new Position(position.row - 1, position.col - 1);
                if(board.getPiece(takeRight)!= null && board.getPiece(takeRight).getColor() != 'W')possibleMoves.add(takeRight);
            }
        }
        return possibleMoves;
    }

}
