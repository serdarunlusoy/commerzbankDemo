package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually...
 */
public class NaivePyramidSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int bottomRow = pyramid.getRows() - 1;
        
        return getTotalAbove(pyramid, bottomRow, 0);
    }

    private long getTotalAbove(Pyramid pyramid, int row, int col) {
        int value = pyramid.get(row, col);

        
        if (row == 0) {
            return value;
        }

        
        long left = getTotalAbove(pyramid, row - 1, col);
        long right = getTotalAbove(pyramid, row - 1, col + 1);

        return value + Math.max(left, right);
    }
}