package ru.batyrev.infecuritymethods.steganography;

import java.io.*;

public class DoubleSpaceEncryptor implements Encryptor {

    private final File container;

    public DoubleSpaceEncryptor(File container) {
        this.container = container;
    }

    @Override
    public void encrypt(String inputText) {
        try (BufferedReader reader = new BufferedReader(new FileReader(container))) {
            StringBuilder binaryString = toBinaryString(inputText);

            String tmpStr;
            int pos = 0;
            StringBuilder result = new StringBuilder();

            while ((tmpStr = reader.readLine()) != null) {
                for (int i = 0; i < tmpStr.length(); i++) {
                    if (tmpStr.charAt(i) == ' ') {
                        if (pos < binaryString.length()) {
                            if (binaryString.charAt(pos) == '1') {
                                result.append(' ').append(' ');
                                pos++;
                            } else if (binaryString.charAt(pos) == '0') {
                                result.append(tmpStr.charAt(i));
                                pos++;
                            }
                        } else {
                            result.append(tmpStr.charAt(i));
                        }
                    } else {
                        result.append(tmpStr.charAt(i));
                    }
                }
                result.append("\n");
            }

            reader.close();
            saveToFile(result.toString());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file", e);
        }
    }

    private void saveToFile(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(container))) {
            writer.write(result);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file", e);
        }
    }

    private StringBuilder toBinaryString(String inputText) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (byte symbol : inputText.getBytes("UTF-8")) {
            result.append(fillHighBits(Integer.toBinaryString(symbol)));
        }
        return result;
    }

    private char[] fillHighBits(String binaryString) {
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
