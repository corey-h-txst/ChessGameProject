import Pieces.*;
import UtilityClasses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public Color color;
    public ArrayList<Piece> pieces;

    public Player(Color color){
        this.color = color;
        this.pieces = new ArrayList<Piece>();
    }

    public void makeMove(Scanner input, Board board){
        int col;
        int row;
        String selected = input.next();
        String target = input.next();

        col = selected.charAt(0) - 'A';
        row = selected.charAt(1) - '1';
        Position selectedPosition = new Position(col, selected.charAt(1));

        col = target.charAt(0) - 'A';
        row = selected.charAt(1) - '1';
        Position targetPosition = new Position(col, target.charAt(1));

        ArrayList<Position> possibleMoves = board.getPiece(selectedPosition).possibleMoves();
        if(possibleMoves.contains(targetPosition)){
            board.movePiece(selectedPosition, targetPosition);
        }
        else {
            System.out.println("Invalid move, please try again.");
            makeMove(input, board);
        }
        return;
    }
}
