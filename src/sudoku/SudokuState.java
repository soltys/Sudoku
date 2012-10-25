package sudoku;

import klesk.math.search.State;
import klesk.math.search.StateImpl;

/**
 *
 * @author Soltys
 */
public class SudokuState extends StateImpl {

    private final int n;
    private final int n2;
    private byte[][] board;
    private final SudokuPrinter printer;

    public SudokuState(int n, State parent) {
        super(parent);
        this.n = n;
        this.n2 = n * n;
        board = new byte[n2][n2];
        printer = new SudokuPrinter(board.length);
    }

    /**
     * Sets value of row and column in Sudoku board
     */
    public void setNumber(int row, int column, byte value) {
        try {
            board[row][column] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("row " + row + " column " + column + " value " + value);
            throw e;
        }
    }

    /**
     * Gets number in row and column in Sudoku board
     *
     * @return byte which is in range of 0-n^2
     */
    public byte getNumber(int row, int column) {
        return board[row][column];
    }

    public byte[][] getBoard() {
        return board;
    }

    public void loadSudokuFromString(String sudokuData) {
        if (sudokuData == null) {
            throw new NullPointerException();
        }

        board = new byte[n2][n2];

        int row = 0;
        int column = 0;
        for (String token : sudokuData.split(",")) {
            byte value = 0;
            try {
                value = Byte.parseByte(token);
            } catch (NumberFormatException e) {
                //ingnoring
            }

            setNumber(row, column, value);

            column++;
            if (column == board.length) {
                column = 0;
                row++;
            }
        }

    }

    @Override
    public String toString() {
        return printer.printSudoku(board);
    }

    @Override
    public double computeHeuristicGrade() {
        return 0;
    }

    @Override
    public String getHashCode() {
        return printer.printSudoku(board);
    }

    @Override
    public boolean isSolution() {
        return SudokuChecker.isSolution(board);
    }

    @Override
    public boolean isValid() {
        return SudokuChecker.isValid(board);
    }
}
