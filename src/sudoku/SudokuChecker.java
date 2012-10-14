/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Soltys
 */
public class SudokuChecker
{

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
