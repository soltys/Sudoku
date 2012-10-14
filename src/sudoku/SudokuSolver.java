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

    public SudokuSolver(State aInitialState,
                        boolean aIsStopAfterFirstSolution,
                        boolean aIsStopAfterSecondSolution)
    {
        super(aInitialState,
              aIsStopAfterFirstSolution,
              aIsStopAfterSecondSolution);
    }


    @Override
    public boolean isSolution(State aState)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void buildChildren(State aParent)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
