package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class King extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'K';

    public King(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Position possible = new Position(0, 0);
        int[][] kingMoves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1},
        };
        for(int[] move : kingMoves){
            int row = position.row + move[0];
            int col = position.col + move[1];
            if (row > -1 && row < 8 && col > -1 && col < 8){
                possible.row = row;
                possible.col = col;
                if(board.getPiece(possible).getColor() != color.color) possibleMoves.add(new Position(row, col));
            }
        }
        return possibleMoves;
    }
}
