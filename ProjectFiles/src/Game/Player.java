package Game;

import Pieces.*;
import UtilityClasses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public Color color;
    public ArrayList<Piece> pieces = new ArrayList<Piece>();

    // Default constructor
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
        // Adds all non-pawn pieces to pieces array
        pieces.add(new Rook(color, new Position(mainRow, 0)));
        pieces.add(new Rook(color, new Position(mainRow, 7)));
        pieces.add(new Knight(color, new Position(mainRow, 1)));
        pieces.add(new Knight(color, new Position(mainRow, 6)));
        pieces.add(new Bishop(color, new Position(mainRow, 2)));
        pieces.add(new Bishop(color, new Position(mainRow, 5)));
        pieces.add(new Queen(color, new Position(mainRow, 3)));
        pieces.add(new King(color, new Position(mainRow, 4)));
        // Adds pawns to pieces array
        for (int col = 0; col < 8; col++){
            pieces.add(new Pawn(color, new Position(pawnRow, col)));
        }
        // Adds all pieces to board
        for (Piece p : pieces){
            board.board.get(p.position.row).get(p.position.col).piece.add(p);
        }
    }
    // Handles making all moves
    public void makeMove(Scanner input, Board board){
        // Loop to ensure a valid move is entered
        while(true) {
            System.out.print("Please enter your move: ");
            String line = input.nextLine().trim();
            // Splits line into two coordinates to properly validate both coordinates are valid
            String[] coords = line.split("\\s+");
            if(coords.length != 2) {
                System.out.println("Invalid input format. Use format like 'E2 E4'.");
                continue;
            }

            String selected = coords[0];
            String target = coords[1];

            if (selected.length() != 2 || target.length() != 2) {
                System.out.println("Invalid input format. Use format like 'E2 E4'.");
                continue;
            }
            char selectedColChar = Character.toUpperCase(selected.charAt(0));
            char selectedRowChar = selected.charAt(1);
            char targetColChar = Character.toUpperCase(target.charAt(0));
            char targetRowChar = target.charAt(1);

            if (selectedColChar < 'A' || selectedColChar > 'H' ||
                    targetColChar < 'A' || targetColChar > 'H' ||
                    selectedRowChar < '1' || selectedRowChar > '8' ||
                    targetRowChar < '1' || targetRowChar > '8') {
                System.out.println("Invalid board position. Columns A-H, Rows 1-8.");
                continue;
            }

            // Converts chess coordinates to Position class for easier handling
            int col = selectedColChar - 'A';
            int row = 8 - (selectedRowChar - '0');
            Position selectedPosition = new Position(row, col);

            col = targetColChar - 'A';
            row = 8 - (targetRowChar - '0');
            Position targetPosition = new Position(row, col);

            // Prevents moving null pieces and pieces of opponent
            Piece piece = board.getPiece(selectedPosition);
            if(piece == null){
                System.out.println("No piece at that position.");
                continue;
            }
            if(piece.color != this.color){
                System.out.println("Cannot move opponent's pieces.");
                continue;
            }

            // Determines if move is legal (i.e. making a move that leads to checkmate on yourself)
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
