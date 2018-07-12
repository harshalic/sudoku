package org.harshalic.sudoku;

public class Sudoku {
    private IReader reader;
    private IWriter writer;
    private ISolver solver;

    public Sudoku(IReader reader, ISolver solver, IWriter writer) {
        this.reader = reader;
        this.solver = solver;
        this.writer = writer;
    }

    public void solve() {
        int[][] puzzle = reader.getConfiguration();
        int code = solver.solve(puzzle);
        if (code == 200) {
            writer.printSolution(puzzle);
        } else {
            writer.printError(code);
        }
    }
}
