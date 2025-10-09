package Pieces;

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
    public ArrayList<Position> possibleMoves(){
        return new ArrayList<>();
    }
    @Override
    public void move(Position position){
        return;
    }
}
