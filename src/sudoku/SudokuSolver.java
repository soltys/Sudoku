/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import klesk.math.search.AStarSearcher;
import klesk.math.search.State;

/**
 *
 * @author Soltys
 */
public class SudokuSolver extends AStarSearcher
{

    public SudokuSolver(State initialState,
                        boolean isStopAfterFirstSolution,
                        boolean isStopAfterSecondSolution)
    {
        super(initialState,
              isStopAfterFirstSolution,
              isStopAfterSecondSolution);
    }


    @Override
    public boolean isSolution(State state)
    {
        return state.isSolution();

    }

    @Override
    public void buildChildren(State parent)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
