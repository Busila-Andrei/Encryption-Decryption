package org.example;

import org.example.service.Menu;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        String mode = "enc";
        String data = "";
        int key = 0;
        String in = "";
        String out = "";
        String alg = "shift";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }
        Menu menu = new Menu();
        try {
            menu.start(mode, data, key, in, out, alg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
