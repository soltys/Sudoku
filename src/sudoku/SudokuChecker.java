/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Soltys
 */
public class SudokuChecker {

    public static boolean isSolved(final byte[][] board) {
        if (isValid(board)) {
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board.length; column++) {
                    if (board[row][column] == 0) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean isValid(final byte[][] board) {
        if (board == null) {
            throw new NullPointerException();
        }
        int boardSize = board.length;
        for (byte[] row : board) {
            if (row.length != boardSize) {
                throw new IllegalArgumentException("Sudoku board is not square");
            }
        }
        //check each row
        byte[] sudokuRow = new byte[board.length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                sudokuRow[column] = board[row][column];
            }
            if (duplicationCheck(sudokuRow)) {
                return false;
            }
        }
        
        //check each column
        byte[] sudokuColumn = new byte[board.length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                sudokuColumn[column] = board[column][row];
            }
            if (duplicationCheck(sudokuColumn)) {
                return false;
            }
        }

        //check each box
       
        int n = (int) Math.sqrt(board.length);
        for (int box = 0; box < board.length; box++) {
            byte[] sudokuBox = new byte[board.length];
            int boxRow = box / n;
            int boxColumn = box % n;
            int indexRowOffset = boxRow * n;
            int indexColumnOffset = boxColumn * n;
            for (int index = 0; index < board.length; index++) {
                sudokuBox[index] = board[indexRowOffset + (index / n)][indexColumnOffset +(index % n)];
            }
            if (duplicationCheck(sudokuBox)) {
                return false;                        
            }            
        }
        return true;
    }

    private static boolean duplicationCheck(byte[] data) {
        for (int index = 0; index < data.length; index++) {
            byte value = data[index];
            if (value != 0) {
                for (int j = index + 1; j < data.length; j++) {
                    if (value == data[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
