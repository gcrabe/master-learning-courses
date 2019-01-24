package ru.batyrev.infecuritymethods.steganography;

import java.io.*;

public class ReplaceEncryptor implements Encryptor {

    private final File container;

    public ReplaceEncryptor(File container) {
        this.container = container;
    }

    @Override
    public void encrypt(String inputText) {
        StringBuilder res;
        try (BufferedReader reader = new BufferedReader(new FileReader(container))) {
            StringBuilder binaryString = toBinaryString(inputText);

            String temp;
            int pos = 0;
            res = new StringBuilder();

            while ((temp = reader.readLine()) != null) {
                for (int i = 0; i < temp.length(); i++) {
                    Character replaceChar;

                    if ((replaceChar = Dictionary.get(temp.charAt(i))) != null) {
                        if (pos < binaryString.length()) {
                            if (binaryString.charAt(pos) == '1') {
                                res.append(replaceChar);
                                pos++;
                            } else if (binaryString.charAt(pos) == '0') {
                                res.append(temp.charAt(i));
                                pos++;
                            }
                        } else {
                            res.append(temp.charAt(i));
                        }
                    } else {
                        res.append(temp.charAt(i));
                    }
                }

                res.append("\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(container));
            writer.write(res.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private StringBuilder toBinaryString(String inputText) throws UnsupportedEncodingException {
        StringBuilder res = new StringBuilder();
        for (byte symbol : inputText.getBytes("UTF-8")) {
            res.append(prefix(Integer.toBinaryString(symbol)));
        }
        return res;
    }

    private char[] prefix(String binaryString) {
        int bitSize = 8;

        if (binaryString.length() == bitSize) {
            return binaryString.toCharArray();
        } else {
            char[] result = new char[bitSize];
            for (int i = 0; i < bitSize; i++) {
                result[i] = i < (bitSize - binaryString.length()) ?
                        '0' : binaryString.charAt(binaryString.length() - (bitSize - i));
            }
            return result;
        }
    }
}

