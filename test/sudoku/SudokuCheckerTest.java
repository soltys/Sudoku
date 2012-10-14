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
public class SudokuCheckerTest
{

    public SudokuCheckerTest()
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
    }

    @After
    public void tearDown()
    {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test(expected=NullPointerException.class)
    public void if_board_is_null_throw_null_exception()
    {
        SudokuChecker.isValid(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void if_board_is_not_squared_throw_illegalArgumentException()
    {
        byte[][] board = new byte[3][2];
        SudokuChecker.isValid(board);
    }
}
