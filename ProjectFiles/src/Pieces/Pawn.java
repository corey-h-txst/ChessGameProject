package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Pawn extends Piece{
    public final char symbol = 'P';

    public Pawn(Color color, Position position){
        super(color, position);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> possibleMoves = new ArrayList<>();
        if(color.color == 'B'){
            Position forward = new Position(position.row + 1, position.col);
            if (board.isValidPosition(forward) && board.getPiece(forward) == null) {
                possibleMoves.add(forward);
            }
            Position takeLeft = new Position(position.row + 1, position.col + 1);
            if (board.isValidPosition(takeLeft) && board.getPiece(takeLeft) != null && board.getPiece(takeLeft).color != color) {
                possibleMoves.add(takeLeft);
            }
            Position takeRight = new Position(position.row + 1, position.col - 1);
            if (board.isValidPosition(takeRight) && board.getPiece(takeRight) != null && board.getPiece(takeRight).color != color) {
                possibleMoves.add(takeRight);
            }
        }
        else{
            Position forward = new Position(position.row - 1, position.col);
            if (board.isValidPosition(forward) && board.getPiece(forward) == null) {
                possibleMoves.add(forward);
            }
            Position takeLeft = new Position(position.row - 1, position.col + 1);
            if (board.isValidPosition(takeLeft) && board.getPiece(takeLeft) != null && board.getPiece(takeLeft).color != color) {
                possibleMoves.add(takeLeft);
            }
            Position takeRight = new Position(position.row - 1, position.col - 1);
            if (board.isValidPosition(takeRight) && board.getPiece(takeRight) != null && board.getPiece(takeRight).color != color) {
                possibleMoves.add(takeRight);
            }
        }
        return possibleMoves;
    }

}
