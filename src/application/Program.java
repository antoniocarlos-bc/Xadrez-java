package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
	
          	int i = 0;
		while(i<10) {
			
			try {
			UI.clearScreen();
			UI.printBoard(chessMatch.getPiece());
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturePiece = chessMatch.performChessMove(source, target);
			i++;
		
			}
			catch(ChessException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			catch(RuntimeException e)
			{
				System.out.println("Unespected problem.");
				
			}
		}
	}
}
