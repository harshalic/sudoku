package org.harshalic.sudoku;

import org.harshalic.sudoku.input.*;
import org.harshalic.sudoku.output.*;
import org.harshalic.sudoku.compute.*;

public class Main {
    public static void main(String[] args) {
        // Sudoku sudoku = new Sudoku(new ConsoleReader(), new RecursiveSolver(), new ConsoleWriter());
        Sudoku sudoku = new Sudoku(new FileReader("./puzzles/puzzle1.txt"), new RecursiveSolver(), new ConsoleWriter());
        sudoku.solve();
    }
}