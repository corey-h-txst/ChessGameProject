import UtilityClasses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Board chessBoard;
    public Player white;
    public Player black;
    public Player currentTurn;

    public Game()
    {
        this.chessBoard = new Board();
        this.white = new Player(new Color('W'));
        this.black = new Player(new Color('B'));
        this.currentTurn = white;
    }

    public void start(){
        for (int row = 0; row < 8; row++){
            ArrayList<Square> boardRow = new ArrayList<Square>();
            for (int col = 0; col < 8; col++){
                String pattern = ((row + col) % 2 == 0) ? "##" : "  ";
                boardRow.add(new Square(pattern));
            }
            chessBoard.board.add(boardRow);
        }
    }
    public void end(){
        if (currentTurn == white){
            System.out.println("Black wins!");
        }
        else System.out.println("White wins!");
    }
    public void play(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Console Chess!");
        System.out.println("To make a move type to position of the piece you want to move");
        System.out.println("followed by the desired position. EX: \"C2 C3\"");
        System.out.println("White will move first, good luck!");
        while (!chessBoard.isCheckmate(currentTurn.color)){
            currentTurn.makeMove(input, chessBoard);

            if(currentTurn == white) currentTurn = black;
            else currentTurn = white;
        }
        end();
    }
}
