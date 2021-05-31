package org.example.service;

import org.example.domain.Crypt;
import org.example.persistance.FileIn;
import org.example.persistance.FileOut;

import java.io.IOException;

public class Menu {

    public void start(String mode, String data, int key, String in, String out,String alg) throws IOException {
        String result = "";
        if (data.isEmpty()) {
            if (!in.isEmpty()) {
                FileIn fileIn = new FileIn(in);
                data = fileIn.load();
                result = Crypt.crypt(mode, data, key,alg);
                fileIn.close();
            }
        } else result = Crypt.crypt(mode, data, key,alg);

        if (out.isEmpty())
            System.out.println(result);
        else {
            FileOut fileOut = new FileOut(out);
            fileOut.save(result);
            fileOut.close();
        }
    }
}
