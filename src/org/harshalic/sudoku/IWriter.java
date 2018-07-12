package org.harshalic.sudoku;

public interface IWriter {
    public void printSolution(int[][] configuration);

    public void printError(int error);
}
