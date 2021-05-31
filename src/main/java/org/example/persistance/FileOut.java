package org.example.persistance;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOut {

    private final BufferedWriter bufferedWriter;

    public FileOut(String pathFile) throws IOException {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
        } catch (IIOException e) {
            throw new RuntimeException("Failed to open file: " + pathFile);
        }
    }


    public void save(String result) throws IOException {
        bufferedWriter.write(result);
    }

    public void close() throws IOException {
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IIOException e) {
            throw new RuntimeException("Failed to save file");
        }
    }
}
