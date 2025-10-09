package Pieces;

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
    public ArrayList<Position> possibleMoves(){
        return new ArrayList<>();
    }
    @Override
    public void move(Position position){
        return;
    }
}
