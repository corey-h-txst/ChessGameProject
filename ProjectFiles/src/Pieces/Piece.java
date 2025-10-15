package Pieces;

import UtilityClasses.*;
import Game.Board;

import java.util.ArrayList;

public class Piece {
    public Color color;
    public Position position;
    public final char symbol = ' ';

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public char getColor(){
        return color.color;
    }

    public ArrayList<Position> possibleMoves(Board board){
        return new ArrayList<Position>();
    }
}
