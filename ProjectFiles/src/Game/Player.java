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

        if(charColor == 'W')
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
        while(true) {
            System.out.print("Please enter your move: ");

            String selected = input.next();
            String target = input.next();

            int col = Character.toUpperCase(selected.charAt(0)) - 'A';
            int row = 8 - (selected.charAt(1) - '1') - 1;
            Position selectedPosition = new Position(row, col);

            col = Character.toUpperCase(target.charAt(0)) - 'A';
            row = 8 - (target.charAt(1) - '1') - 1;
            Position targetPosition = new Position(row, col);

            Piece piece = board.getPiece(selectedPosition);
            if(piece == null){
                System.out.println("No piece at that position.");
                continue;
            }
            if(piece.color != this.color){
                System.out.println("Cannot move opponent's pieces.");
                continue;
            }

            ArrayList<Position> legalMoves = new ArrayList<>();
            for (Position move : piece.possibleMoves(board)) {
                Piece captured = board.getPiece(move);
                Position originalPos = piece.position;

                board.movePiece(originalPos, move);

                if (!board.isCheck(piece.color)) {
                    legalMoves.add(move);
                }

                board.board.get(originalPos.row).get(originalPos.col).piece.add(piece);
                piece.position = originalPos;
                board.board.get(move.row).get(move.col).piece.clear();
                if (captured != null) board.board.get(move.row).get(move.col).piece.add(captured);
            }

            if (legalMoves.contains(targetPosition)) {
                board.movePiece(selectedPosition, targetPosition);
                break;
            } else {
                System.out.println("Invalid move, your king would be in check or move is not allowed. Try again.");
            }
        }
    }
}
