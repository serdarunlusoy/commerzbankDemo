package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

import java.util.Objects;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        Objects.requireNonNull(pyramid, "pyramid");

        final int rows = pyramid.getRows();
        if (rows == 0) return 0L;

        
        
        long[] below = new long[1];
        below[0] = pyramid.get(rows - 1, 0);

        
        for (int r = rows - 2; r >= 0; r--) {
            final int cols = rows - r;            
            long[] current = new long[cols];

            for (int c = 0; c < cols; c++) {
                int cellValue = pyramid.get(r, c);

                if (c == 0) {
                    
                    current[c] = cellValue + below[0];
                } else if (c == cols - 1) {
                    
                    current[c] = cellValue + below[c - 1];
                } else {
                    
                    current[c] = cellValue + Math.max(below[c - 1], below[c]);
                }
            }

            below = current; 
        }

        
        long max = Long.MIN_VALUE;
        for (long v : below) {
            if (v > max) max = v;
        }
        return max;
    }

}
