/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Soltys
 */
public class SudokuStateTest
{
    SudokuState sudokuState;

    public SudokuStateTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        sudokuState = new SudokuState(3, null);
    }

    @After
    public void tearDown()
    {
        sudokuState = null;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void if_sudoku_string_is_empty_all_numbers_are_equals_zero()
    {
        sudokuState.loadSudokuFromString("");

        byte[][] board = sudokuState.getBoard();
        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board.length; column++)
            {
                assertEquals(0, board[row][column]);
            }
        }
    }

    @Test(expected=NullPointerException.class)
    public void if_sudoku_string_is_null_throw_PointerNullException()
    {
        sudokuState.loadSudokuFromString(null);
    }



}
