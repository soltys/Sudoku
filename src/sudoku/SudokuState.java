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
        computeHeuristicGrade();
    }
    public SudokuState(int n,String sudokuData, State parent)
    {
        super(parent);
        this.n = n;
        this.n2 = n * n;
        board = new byte[n2][n2];
        printer = new SudokuPrinter(board.length);
    }

    public SudokuState(State parent) {
        super(parent);
        SudokuState sudokuState = (SudokuState) parent;
        this.n = sudokuState.getN();
        this.n2 = sudokuState.getN2();
        board = new byte[n2][n2];
        byte[][] parentSudoku = sudokuState.getBoard();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = parentSudoku[row][column];
            }
        }

        printer = new SudokuPrinter(board.length);
    }
    
    public int getN() {
        return n;
    }

    public int getN2() {
        return n2;
    }

    /**
     * Sets value of row and column in Sudoku board
     *
     * @param row
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

    /**
     * Loads Sudoku from string, values should be separated by ','
     *
     * @param sudokuData numbers in one line separated by ','
     */
    public void loadSudokuFromString(String sudokuData) {
        loadSudokuFromString(sudokuData, ",");
    }

    /**
     * Loads Sudoku from string
     *
     * @param sudokuData
     * @param separator
     */
    public void loadSudokuFromString(String sudokuData, String separator) {
        if (sudokuData == null) {
            throw new NullPointerException();
        }

        board = new byte[n2][n2];

        int row = 0;
        int column = 0;
        for (String token : sudokuData.split(separator)) {
            byte value = 0;
            try {
                value = Byte.parseByte(token);
            } catch (NumberFormatException e) {
                //ignoring
            }

            setNumber(row, column, value);

            column++;
            if (column == board.length) {
                column = 0;
                row++;
            }
        }
        computeHeuristicGrade();
    }

    @Override
    public String toString() {
        return printer.printSudoku(board);
    }

    @Override
    public double computeHeuristicGrade() {
        int counter = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] == 0) {
                    counter++;
                }
            }
        }
        setH(counter);
        return counter;
    }

    @Override
    public String getHashCode() {        
        return Integer.toString(this.hashCode());
    }

    @Override
    public boolean isSolved() {
        return SudokuChecker.isValid(board) && getH() == 0;
    }

    @Override
    public boolean isValid() {
        return SudokuChecker.isValid(board);
    }

    @Override
    public boolean isAdmissible() {
        return SudokuChecker.isValid(board);
    }
    
      public static void main(String[] args) {
        SudokuState sudokuState = new SudokuState(3, null);
        String sudokuData = ""
                + "5,3,0,0,7,0,0,0,0,"
                + "6,0,0,1,9,5,0,0,0,"
                + "0,9,8,0,0,0,0,6,0,"
                + ""
                + "8,0,0,0,6,0,0,0,3,"
                + "4,0,0,8,0,3,0,0,1,"
                + "7,0,0,0,2,0,0,0,6,"
                + ""
                + "0,6,0,0,0,0,2,8,0,"
                + "0,0,0,4,1,9,0,0,5,"
                + "0,0,0,0,8,0,0,7,9";
        sudokuState.loadSudokuFromString(sudokuData);
        System.out.println(sudokuState);
        System.out.println(sudokuState.isAdmissible());
    }
}
