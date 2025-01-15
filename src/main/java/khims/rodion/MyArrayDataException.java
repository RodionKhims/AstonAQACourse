package khims.rodion;

public class MyArrayDataException extends Exception {
    private final int row;
    private final int col;

    public MyArrayDataException(int row, int col) {
        super("Invalid data at row: " + row + ", col: " + col);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
