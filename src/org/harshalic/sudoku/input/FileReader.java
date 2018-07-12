package org.harshalic.sudoku.input;

import org.harshalic.sudoku.IReader;

import java.io.File;
import java.util.Scanner;

public class FileReader implements IReader {
    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int[][] getConfiguration() {
        int[][] config = new int[9][9];
        try {
            File file = new File(this.filePath);
            try (Scanner scanner = new Scanner(file)) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        config[i][j] = scanner.nextInt();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return config;
    }
}
