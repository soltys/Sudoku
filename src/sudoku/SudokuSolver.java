/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;
import klesk.math.search.AStarSearcher;
import klesk.math.search.State;

/**
 *
 * @author Soltys
 */
public class SudokuSolver extends AStarSearcher {

    public SudokuSolver(State initialState,
            boolean isStopAfterFirstSolution,
            boolean isStopAfterSecondSolution) {
        super(initialState,
                isStopAfterFirstSolution,
                isStopAfterSecondSolution);
    }

    @Override
    public boolean isSolution(State state) {
        return state.isSolved();
    }

    @Override
    public void buildChildren(State parent) {
        SudokuState state = (SudokuState) parent;
        int i=0, j=0;
        int n4 = state.getN2() * state.getN2();
        for (int k = 0; k < n4; k++) {
            i = k / state.getN2();
            j = k % state.getN2();
            if (state.getBoard()[i][j] == 0) {
                break;
            }

        }
        List<State> children = new ArrayList<>();
        for (int k = 0; k < state.getN2(); k++) {
            SudokuState child = new SudokuState(state);
            child.setNumber(i, j, (byte) (k + 1));
            if (child.isAdmissible()) {
                child.computeHeuristicGrade();
                children.add(child);
            }
            state.setChildren(children);
        }
    }
}
