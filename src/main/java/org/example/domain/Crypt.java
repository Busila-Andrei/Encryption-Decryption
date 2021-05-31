package org.example.domain;

public class Crypt {

    public static String crypt(String mode, String text, int key, String alg) {
        StringBuilder result = new StringBuilder();
        switch (alg) {
            case "shift":
                switch (mode) {
                    case "enc":
                        for (int i = 0; i < text.length(); i++) {
                            char ch = text.charAt(i);
                            char crypt;
                            if (Character.isLetter(ch)) {
                                if (ch >= 65 && ch + key > 90 && ch <= 90 ||
                                        ch >= 96 && ch + key > 122 && ch <= 122) {
                                    crypt = (char) (ch + key - 26);
                                } else crypt = (char) (ch + key);
                            } else crypt = ch;
                            result.append(crypt);
                        }
                        break;
                    case "dec":
                        for (int i = 0; i < text.length(); i++) {
                            char ch = text.charAt(i);
                            char crypt;
                            if (Character.isLetter(ch)) {
                                if (ch >= 65 && ch - key < 65 && ch <= 90 ||
                                        ch >= 96 && ch - key < 96 && ch <= 122) {
                                    crypt = (char) (ch - key + 26);
                                } else crypt = (char) (ch - key);
                            } else crypt = ch;
                            result.append(crypt);
                        }
                        break;


                }
                break;

            case "unicode":
                switch (mode) {
                    case "enc":
                        for (int i = 0; i < text.length(); i++) {
                            char ch = text.charAt(i);

                            char crypt = (char) (ch + key);
                            result.append(crypt);
                        }
                        break;
                    case "dec":
                        for (int i = 0; i < text.length(); i++) {
                            char ch = text.charAt(i);
                            char crypt = (char) (ch - key);
                            result.append(crypt);
                        }
                        break;
                }
                break;
        }
        return result.toString();
    }
}
