package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] piecesMatrix;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        areBoardDimensionsValid();
        piecesMatrix = new Piece[rows][columns];
    }

    private void areBoardDimensionsValid() {
        if (this.rows < 1 || this.columns <1) {
            throw new BoardException("Error in creating board: there must be at least 1 row and 1 column");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        isPiecePositionValid(row, column);
        return piecesMatrix[row][column];
    }

    public Piece piece(Position position) {
        isPiecePositionValid(position.getRow(), position.getColumn());
        return piecesMatrix[position.getRow()][position.getColumn()];
    }

    private void isPiecePositionValid(int row, int column) {
        if (!positionOnBoard(row, column)) {
            throw new BoardException("Position not on the board");
        }
    }

    private void isPiecePositionValid(Position position) {
        if (!positionOnBoard(position.getRow(), position.getColumn())) {
            throw new BoardException("Position not on the board");
        }
    }

    public void placePieceOnBoard(Piece piece, Position piecePosition) {
        isPositionNotOccupied(piecePosition);
        piecesMatrix[piecePosition.getRow()][piecePosition.getColumn()] = piece;
        piece.position = piecePosition;
    }

    private void isPositionNotOccupied(Position position) {
        if (isThereAPieceOnThisPosition(position)) {
            throw new BoardException("There's already a piece on position " + position);
        }
    }

    public boolean positionOnBoard(int row, int column) {
        boolean rowOnboard = (row >= 0 && row < rows);
        boolean columnOnBoard = (column >= 0 && column < columns);

        return rowOnboard && columnOnBoard;
    }

    public boolean positionOnBoard(Position position) {
        boolean rowOnboard = (position.getRow() >= 0 && position.getRow() < rows);
        boolean columnOnBoard = (position.getColumn() >= 0 && position.getColumn() < columns);

        return rowOnboard && columnOnBoard;
    }

    public boolean isThereAPieceOnThisPosition(Position position) {
        isPiecePositionValid(position);
        return piece(position) != null;
    }
}
