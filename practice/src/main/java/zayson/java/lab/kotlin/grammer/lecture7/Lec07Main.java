package zayson.java.lab.kotlin.grammer.lecture7;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec07Main {
    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Integer parseIntOrThrowV2(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        System.out.println(reader.readLine());
        reader.close();
    }

    // try-with-resources
    public void readFileV2(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
