package Pieces;

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
    public ArrayList<Position> possibleMoves(){
        return new ArrayList<>();
    }
    @Override
    public void move(Position position) {
        return;
    }
}
