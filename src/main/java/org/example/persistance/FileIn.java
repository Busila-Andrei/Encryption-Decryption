package org.example.persistance;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileIn {

    private final Scanner scanner;

    public FileIn(String pathFile) throws IOException {
        scanner = new Scanner(new File(pathFile));
    }

    public String load(){
        return scanner.nextLine();
    }
    public void close() {
        scanner.close();
    }
}
