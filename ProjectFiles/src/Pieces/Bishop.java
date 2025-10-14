package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Color color;
    public Position position;
    public final char symbol = 'B';

    public Bishop(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int[][] bishopMoves = {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        Position possible = new Position(0, 0);

        for (int[] move : bishopMoves) {
            int row = position.row + move[0];
            int col = position.col + move[1];

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
