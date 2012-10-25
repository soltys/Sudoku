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
public class SudokuCheckerTest {

    public SudokuCheckerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test(expected = NullPointerException.class)
    public void if_board_is_null_throw_null_exception() {
        SudokuChecker.isValid(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void if_board_is_not_squared_throw_illegalArgumentException() {
        byte[][] board = new byte[3][2];
        SudokuChecker.isValid(board);
    }

    @Test
    public void sudoku_board_is_solved() {
        byte[][] board = getSampleSudoku();
        boolean actual = SudokuChecker.isSolved(board);
        assertTrue(actual);
    }

    @Test
    public void sudoku_board_is_valid() {
        byte[][] board = getSampleSudoku();
        boolean actual = SudokuChecker.isValid(board);
        assertTrue(actual);
    }

    @Test
    public void sudoku_board_is_invalid_row_duplication() {
        byte[][] board = new byte[4][4];
        board[0][0] = 4;        
        board[0][3] = 4;
        boolean acutal = SudokuChecker.isValid(board);
        assertFalse(acutal);
    }
    
    @Test
    public void sudoku_board_is_invalid_column_duplication() {
        byte[][] board = new byte[4][4];
        board[0][0] = 4;
        board[3][0] = 4;
        boolean acutal = SudokuChecker.isValid(board);
        assertFalse(acutal);
    }
    
    @Test
    public void sudoku_board_is_invalid_box_duplication() {
        byte[][] board = new byte[4][4];
        board[0][0] = 4;
        board[1][1] = 4;
        boolean acutal = SudokuChecker.isValid(board);
        assertFalse(acutal);
    }


    private byte[][] getSampleSudoku() {
        byte[][] board = new byte[4][4];
        //1,2,3,4,
        //3,4,1,2,
        //2,1,4.3
        //4.3.2.1
        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 3;
        board[0][3] = 4;
        board[1][0] = 3;
        board[1][1] = 4;
        board[1][2] = 1;
        board[1][3] = 2;
        board[2][0] = 2;
        board[2][1] = 1;
        board[2][2] = 4;
        board[2][3] = 3;
        board[3][0] = 4;
        board[3][1] = 3;
        board[3][2] = 2;
        board[3][3] = 1;
        return board;
    }
}
