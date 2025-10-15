package Game;

import Pieces.*;
import UtilityClasses.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Board {
    public ArrayList<ArrayList<Square>> board;
    public ArrayList<Piece> capturedPieces;

    public Board() {
        this.board = new ArrayList<ArrayList<Square>>();
        for (int row = 0; row < 8; row++){
            ArrayList<Square> boardRow = new ArrayList<Square>();
            for (int col = 0; col < 8; col++){
                String pattern = ((row + col) % 2 == 0) ? "##" : "  ";
                boardRow.add(new Square(pattern));
            }
            this.board.add(boardRow);
        }
        this.capturedPieces = new ArrayList<>();
    }

    public boolean isValidPosition(Position position){
        if (position == null) return false;
        return position.row >= 0 && position.row < 8 &&
                position.col >= 0 && position.col < 8;
    }

    public Piece getPiece(Position position) {
        if (board.get(position.row).get(position.col).piece.isEmpty()) return null;
        return board.get(position.row).get(position.col).piece.getFirst();
    }

    public void displayBoard(){
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int row = 0; row < 8; row++){
            System.out.print(8 - row + " ");
            for (int col = 0; col < 8; col++){
                System.out.print(board.get(row).get(col).getDisplay() + " ");
            }
            System.out.println();
        }
    }

    public void movePiece(Position curr, Position next) {
        if (!board.get(next.row).get(next.col).piece.isEmpty()) {
            capturedPieces.add(getPiece(next));
            board.get(next.row).get(next.col).piece.clear();
        }
        board.get(next.row).get(next.col).piece.add(getPiece(curr));
        board.get(curr.row).get(curr.col).piece.clear();
    }

    public boolean isCheck(Color color) {
        Position kingSquare = null;
        for (ArrayList<Square> row : board) {
            for (Square square : row) {
                if (!square.piece.isEmpty()) {
                    Piece piece = square.piece.getFirst();
                    if (piece instanceof King && piece.color == color) {
                        kingSquare = piece.position;
                    }
                }
            }
        }
        for (ArrayList<Square> row : board) {
            for (Square square : row) {
                if (!square.piece.isEmpty()) {
                    Piece attack = square.piece.getFirst();
                    if (attack.color != color) {
                        ArrayList<Position> moves = attack.possibleMoves(this);
                        if (moves.contains(kingSquare)) return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(Color color) {
        if (!isCheck(color)) {
            return false;
        }

        Position kingSquare = null;
        for (ArrayList<Square> row : board) {
            for (Square square : row) {
                if (!square.piece.isEmpty()) {
                    Piece piece = square.piece.getFirst();
                    if (piece instanceof King && piece.color == color) {
                        kingSquare = piece.position;
                    }
                }
            }
        }
        HashSet<Position> attacked = new HashSet<Position>();
        for (ArrayList<Square> row : board) {
            for (Square square : row) {
                if (!square.piece.isEmpty()) {
                    Piece piece = square.piece.getFirst();
                    if (piece.color != color) {
                        attacked.addAll(piece.possibleMoves(this));
                    }
                }
            }
        }
        ArrayList<Position> kingMoves = getPiece(kingSquare).possibleMoves(this);
        for(Position move : kingMoves){
            if (!attacked.contains(move)){return false;}
        }
        return true;
    }
}
