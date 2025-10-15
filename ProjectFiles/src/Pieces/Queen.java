package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Queen extends Piece{
    public final char symbol = 'Q';

    public Queen(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Position possible = new Position(0,0);
        int[][] queenMoves = {
                {-1, 0}, {1, 0},
                {0, -1}, {0, 1},
                {-1, -1}, {-1, 1},
                {1, -1}, {1, 1},
        };

        for (int[]move : queenMoves){
            int row = this.position.row + move[0];
            int col = this.position.col + move[1];

            while (true){
                possible.row = row;
                possible.col = col;
                if(!board.isValidPosition(possible)) break;

                Piece target =  board.getPiece(possible);
                if (target != null){
                    if (target.getColor() != color.color) possibleMoves.add(new Position(row, col));
                    break;
                }
                possibleMoves.add(new Position(row, col));

                row += move[0];
                col += move[1];
            }
        }
        return possibleMoves;
    }

}
