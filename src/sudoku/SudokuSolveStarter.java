/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Soltys
 */
public class SudokuSolveStarter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuState sudokuState = new SudokuState(3,null);
        String sudokuData = "5,3,0,0,7,0,0,0,0,"+
                            "6,0,0,1,9,5,0,0,0,"+
                            "0,9,8,0,0,0,0,6,0,"+
                            ""+
                            "8,0,0,0,6,0,0,0,3,"+
                            "4,0,0,8,0,3,0,0,1,"+
                            "7,0,0,0,2,0,0,0,6,"+
                            ""+
                            "0,6,0,0,0,0,2,8,0,"+
                            "0,6,0,4,1,9,0,0,5,"+
                            "0,6,0,0,8,0,0,7,9";
        sudokuState.loadSudokuFromString(sudokuData);
        System.out.println(sudokuState);
    }
}
