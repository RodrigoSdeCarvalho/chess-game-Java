import boardgame.Board;
import chess.ChessPiece;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }

    private ChessPiece[][] generatePiecesMatrix(ChessPiece[][] emptyMatrix) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                emptyMatrix[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return emptyMatrix;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] piecesMatrix = new ChessPiece[board.getRows()][board.getColumns()];
        piecesMatrix = generatePiecesMatrix(piecesMatrix);
        return piecesMatrix;
    }
}
