/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Soltys
 */
public class SudokuChecker
{

    public static boolean isSolution(final byte[][] board)
    {
        if (isValid(board))
        {
            for (int row = 0; row < board.length; row++)
            {
                for (int column = 0; column < board.length; column++)
                {
                    if (board[row][column] == 0)
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }
    public static boolean isValid(final byte[][] board)
    {
        if (board == null)
        {
            throw new NullPointerException();
        }
        int boardSize = board.length;
        for(byte[] row : board )
        {
            if (row.length != boardSize)
            {
                throw new IllegalArgumentException("Sudoku board is not square");
            }
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
