package org.harshalic.sudoku.input;

import org.harshalic.sudoku.IReader;
import java.util.*;

public class ConsoleReader implements IReader {

    @Override
    public int[][] getConfiguration() {
        int[][] config;
        try (Scanner scanner = new Scanner(System.in)) {
            config = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    config[i][j] = scanner.nextInt();
                }
            }
        }
        return config;
    }
}