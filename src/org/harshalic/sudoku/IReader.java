package org.harshalic.sudoku;

public interface IReader {
    // Reads the game configuration and returns a 9x9 array.
    public int[][] getConfiguration();
}