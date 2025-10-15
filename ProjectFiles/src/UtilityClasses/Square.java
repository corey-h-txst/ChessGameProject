package UtilityClasses;

import java.util.ArrayList;
import Pieces.*;

public class Square {
    public String squareBase;
    public ArrayList<Piece> piece;

    public Square(String squareBase) {
        this.squareBase = squareBase;
        this.piece = new ArrayList<Piece>();
    }
    // Used for displaying board state when a piece is or isn't on any given square
    public String getDisplay(){
        if (piece.isEmpty()){
            return squareBase;
        }
        else return ("" + piece.getFirst().getColor() + piece.getFirst().getSymbol());
    }
}
