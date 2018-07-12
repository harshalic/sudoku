package org.harshalic.sudoku.compute;

import org.harshalic.sudoku.ISolver;
import java.util.*;

public class RecursiveSolver implements ISolver {

    public int solve(int[][] matrix) {
        Cell firstEmptyCell = getFirstEmptyCell(matrix);
        if (firstEmptyCell == null) {
            return isValidSudoku(matrix) ? 200 : 404;
        }

        for (int k = 1; k <= 9; k++) {
            matrix[firstEmptyCell.x][firstEmptyCell.y] = k;
            if (isValidSudoku(matrix)) {
                if (solve(matrix) == 200) {
                    return 200;
                }
            }
        }
        matrix[firstEmptyCell.x][firstEmptyCell.y] = 0;
        return 404;
    }

    public Cell getFirstEmptyCell(int[][] matrix) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (matrix[x][y] == 0) {
                    return new Cell(x,y);
                }
            }
        }
        return null;
    }

    public boolean isValidSudoku(int[][] board) {
        int[] values = new int[10];
        Arrays.fill(values, 0);

        // rows
        for (int i = 0; i < 9; i++) {
            Arrays.fill(values, 0);
            for (int j = 0; j < 9; j++) {
                values[board[i][j]]++;
            }
            if (!valid(values)) {
                return false;
            }
        }
        // columns
        Arrays.fill(values, 0);
        for (int i = 0; i < 9; i++) {
            Arrays.fill(values, 0);
            for (int j = 0; j < 9; j++) {
                values[board[j][i]]++;
            }
            if (!valid(values)) {
                return false;
            }
        }

        // matrix
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (!validMatrix(i,j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validMatrix(int x, int y, int[][] board) {
        int[] values = new int[10];
        Arrays.fill(values, 0);

        for (int i = 3*x; i < 3*x+3; i++) {
            for (int j = 3*y; j < 3*y+3; j++) {
                values[board[i][j]]++;
            }
        }

        if (!valid(values)) {
            return false;
        }

        return true;
    }

    public boolean valid(int[] values) {
        for (int i = 1; i <= 9; i++) {
            if (values[i] > 1) {
                return false;
            }
        }
        return true;
    }

    private class Cell {
        public int x, y;
        Cell(int a, int b) {
            x = a;
            y = b;
        }
    }
}