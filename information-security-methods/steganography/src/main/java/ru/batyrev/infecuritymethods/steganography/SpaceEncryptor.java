package ru.batyrev.infecuritymethods.steganography;

import java.io.*;

public class SpaceEncryptor implements Encryptor {

    private final File container;

    public SpaceEncryptor(File container) {
        this.container = container;
    }

    @Override
    public void encrypt(String inputText) {
        try (BufferedReader reader = new BufferedReader(new FileReader(container))) {
            StringBuilder binaryString = toBinaryString(inputText);

            String temp;
            int pos = 0;
            StringBuilder res = new StringBuilder();

            while ((temp = reader.readLine()) != null) {
                if (pos < binaryString.length()) {
                    if (binaryString.charAt(pos) == '1') {
                        temp += " ";
                    }
                }

                res.append(temp).append("\n");
                pos++;
            }

            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(container));
            writer.write(res.toString());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private StringBuilder toBinaryString(String inputText) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (byte symbol : inputText.getBytes("UTF-8")) {
            result.append(prefix(Integer.toBinaryString(symbol)));
        }
        return result;
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
