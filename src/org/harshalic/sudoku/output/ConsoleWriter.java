package org.harshalic.sudoku.output;

import org.harshalic.sudoku.IWriter;

public class ConsoleWriter implements IWriter {
    public void printSolution(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printError(int code) {
        switch (code) {
            case 404:
                System.out.println("A Solution does not exists for the sudoku");
                break;
            default:
                System.out.println("Can't solve the sudoku");
        }

    }
}