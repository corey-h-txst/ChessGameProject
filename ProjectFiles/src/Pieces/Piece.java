package Pieces;

import UtilityClasses.*;
import Game.Board;

import java.util.ArrayList;

public class Piece {
    public Color color;
    public Position position;
    public char symbol = ' ';

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public char getColor(){
        return color.color;
    }

    public char getSymbol(){
        return symbol;
    }

    public ArrayList<Position> possibleMoves(Board board){
        return new ArrayList<Position>();
    }
}
