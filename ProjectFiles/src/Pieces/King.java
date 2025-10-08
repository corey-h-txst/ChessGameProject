package Pieces;

import UtilityClasses.*;

public class King extends Piece{
    public Color color;
    public Position position;
    public final char symbol = 'K';

    public King(Color color, Position position){
        super(color, position);
    }

    @Override
    public Position[] possibleMoves(){
        return new Position[]{};
    }
    @Override
    public void move(Position position){
        return;
    }
}
