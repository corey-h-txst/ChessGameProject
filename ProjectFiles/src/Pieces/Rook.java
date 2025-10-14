package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Rook extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'R';

    public Rook(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Position possible = new Position(position.row, position.col);

        while (possible.row < 8){
            possible.row++;
            if (board.getPiece(possible) != null){
                if (board.getPiece(possible).getColor() != color.color)possibleMoves.add(new Position(possible.row, possible.col));
                break;
            }
        }
        while (possible.col < 8){
            possible.col++;
            if (board.getPiece(possible) != null){
                if (board.getPiece(possible).getColor() != color.color)possibleMoves.add(new Position(possible.row, possible.col));
                break;
            }
        }
        possible.row = this.position.row;
        possible.col = this.position.col;
        while (possible.row > -1){
            possible.row--;
            if (board.getPiece(possible) != null){
                if (board.getPiece(possible).getColor() != color.color)possibleMoves.add(new Position(possible.row, possible.col));
                break;
            }
        }
        while (possible.col > -1){
            possible.col--;
            if (board.getPiece(possible) != null){
                if (board.getPiece(possible).getColor() != color.color)possibleMoves.add(new Position(possible.row, possible.col));
                break;
            }
        }

        return possibleMoves;
    }
}
