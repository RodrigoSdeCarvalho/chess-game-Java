package application;

import chess.ChessPiece;

public class UI {
    public static void printBoard(ChessPiece[][] piecesMatrix) {
        for (int i = 0; i < piecesMatrix.length; i++) {
            System.out.println((8 - i) + " ");
            for (int j = 0; j < piecesMatrix.length; j++) {
                printPiece(piecesMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.println("-");
        } else {
            System.out.println(piece);
        }
        System.out.println(" ");
    }
}
