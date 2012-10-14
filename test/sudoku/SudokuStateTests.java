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
public class SudokuStateTests
{
    SudokuState sudokuState;

    public SudokuStateTests()
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

    @Test(expected=IllegalArgumentException.class)
    public void if_sudoku_string_is_empty_throw_illeagalArgumentException()
    {
        sudokuState.parseSudoku("");
    }

    @Test(expected=NullPointerException.class)
    public void if_sudoku_string_is_null_throw_PointerNullException()
    {
        sudokuState.parseSudoku(null);
    }
}
