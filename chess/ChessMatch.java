package chess;
import boardgame.Board;
import boardgame.Position;
import chess.chesspieces.King;
import chess.chesspieces.Rook;

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

    private void placePieceOnBoard(char column, int row, ChessPiece piece) {
        board.placePieceOnBoard(piece, new ChessPosition(column, row).toPosition());
    }

    private void setupPiecesOnBoard() {
        board.placePieceOnBoard(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePieceOnBoard(new King(board, Color.WHITE), new Position(7, 4));
    }
}
