package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Queen extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'Q';

    public Queen(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        int[][] queenMoves = {
                {-1, 0}, {1, 0},
                {0, -1}, {0, 1},
                {-1, -1}, {-1, 1},
                {1, -1}, {1, 1},
        };
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Position possible = new Position(0,0);
        for (int[]move : queenMoves){
            int row = this.position.row + move[0];
            int col = this.position.col + move[1];

            while (row > -1 && row < 8 && col > -1 && col < 8){
                possible.row = row;
                possible.col = col;

                if (board.getPiece(possible) != null){
                    if (board.getPiece(possible).getColor() != color.color) possibleMoves.add(new Position(row, col));
                    break;
                }
                possibleMoves.add(possible);
                row += move[0];
                col += move[1];
            }
        }
        return possibleMoves;
    }

}
