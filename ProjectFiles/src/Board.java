import Pieces.*;
import UtilityClasses.*;

import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<Square>> board;
    public ArrayList<Piece> capturedPieces;

    public Board(){
        this.board = new ArrayList<ArrayList<Square>>();
        this.capturedPieces = new ArrayList<>();
    }

    public Piece getPiece(Position position){
        return board.get(position.row).get(position.col).piece.getFirst();
    }
    public void movePiece(Position curr, Position next){
        if(board.get(next.row).get(next.col).piece.isEmpty()){
            capturedPieces.add(getPiece(next));
        }
        board.get(next.row).get(next.col).piece.set(0, getPiece(curr));
        board.get(curr.row).get(curr.col).piece.clear();
    }
    public boolean isCheck(Color color){
        return false;
    }
    public boolean isCheckmate(Color color){
        if (!isCheck(color)){return false;}
        return false;
    }
}
