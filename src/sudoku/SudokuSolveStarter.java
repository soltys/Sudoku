/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.List;
import klesk.math.search.State;

/**
 *
 * @author Soltys
 */
public class SudokuSolveStarter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuState sudokuState = new SudokuState(2, null);
        
        String sudokuData = ""
                + "0,0,0,0,7,0,0,0,0,"
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
//        sudokuState.loadSudokuFromString(sudokuData);
        SudokuSolver solver = new SudokuSolver(sudokuState, false, false);
        long startTime = System.currentTimeMillis();
        solver.doSearch();
        long endTime = System.currentTimeMillis();
        System.out.println("Solution time " + (endTime - startTime) + " ms");
        System.out.println("Closed size: " + solver.getClosed().size());
        System.out.println("Solution count : " + solver.getSolutions().size());
//        List<State> solutions = solver.getSolutions();        
//        for(State state : solutions)
//        {
//            System.out.println(state);
//        }        
    }
}
