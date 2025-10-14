package Pieces;

import Game.Board;
import UtilityClasses.*;

import java.util.ArrayList;

public class Knight extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'N';

    public  Knight(Color color, Position position){
        super(color, position);
    }

    @Override
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Position possible = new Position(0,0 );
        int[][] knightMoves = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        for(int[] move : knightMoves){
            int row = position.row + move[0];
            int col = position.col + move[1];
            if (row > -1 && row < 8 && col > -1 && col < 8){
                possible.row = row;
                possible.col = col;
                if(board.getPiece(possible).getColor() != color.color)possibleMoves.add(new  Position(row, col));
            }
            row = position.row + move[1];
            col = position.col + move[0];
            if (row > -1 && row < 8 && col > -1 && col < 8){
                possible.row = row;
                possible.col = col;
                if(board.getPiece(possible).getColor() != color.color)possibleMoves.add(new Position(row, col));
            }
        }
        return possibleMoves;
    }
}
