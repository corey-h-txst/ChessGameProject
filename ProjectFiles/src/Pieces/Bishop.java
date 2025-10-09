package Pieces;

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
    public ArrayList<Position> possibleMoves() {
        return new ArrayList<Position>();
    }
    @Override
    public void move(Position position) {
        return;
    }
}
