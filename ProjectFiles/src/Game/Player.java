package Game;

import Pieces.*;
import UtilityClasses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public Color color;
    public ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Player(Color color, Board board) {
        this.color = color;
        char charColor = this.color.color;
        int mainRow, pawnRow;

        if(charColor == 'B')
        {
            mainRow = 7;
            pawnRow = 6;
        }
        else{
            mainRow = 0;
            pawnRow = 1;
        }

        pieces.add(new Rook(color, new Position(mainRow, 0)));
        pieces.add(new Rook(color, new Position(mainRow, 7)));
        pieces.add(new Knight(color, new Position(mainRow, 1)));
        pieces.add(new Knight(color, new Position(mainRow, 6)));
        pieces.add(new Bishop(color, new Position(mainRow, 2)));
        pieces.add(new Bishop(color, new Position(mainRow, 5)));
        pieces.add(new Queen(color, new Position(mainRow, 3)));
        pieces.add(new King(color, new Position(mainRow, 4)));

        for (int col = 0; col < 8; col++){
            pieces.add(new Pawn(color, new Position(pawnRow, col)));
        }

        for (Piece p : pieces){
            board.board.get(p.position.row).get(p.position.col).piece.add(p);
        }
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
        row = target.charAt(1) - '1';
        Position targetPosition = new Position(col, target.charAt(1));

        ArrayList<Position> possibleMoves = board.getPiece(selectedPosition).possibleMoves(board);
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
