package Pieces;

import UtilityClasses.*;

public class Piece {
    public Color color;
    public Position position;
    public final char symbol = ' ';

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Position[] possibleMoves(){
        return new Position[]{position};
    }
    public void move(Position newPosition){
        return;
    }
}
