package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] piecesMatrix;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        piecesMatrix = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return piecesMatrix[row][column];
    }

    public Piece piece(Position position) {
        return piecesMatrix[position.getRow()][position.getColumn()];
    }

    public void placePieceOnBoard(Piece piece, Position piecePosition) {
        piecesMatrix[piecePosition.getRow()][piecePosition.getColumn()] = piece;
        piece.position = piecePosition;
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
        return piece(position) != null;
    }
}
