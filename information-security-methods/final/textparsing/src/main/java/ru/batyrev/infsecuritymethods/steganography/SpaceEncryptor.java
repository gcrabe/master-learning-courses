package ru.batyrev.infsecuritymethods.steganography;

import java.io.*;

class SpaceEncryptor extends Base implements Encryptor {

    SpaceEncryptor(String fileName) {
        super(fileName);
    }

    void encrypt(String inputText) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder binStr = new StringBuilder();
        byte[] byteArray = inputText.getBytes("CP1251");
        for (byte b : byteArray) {
            binStr.append(format(Integer.toBinaryString(b)));
        }

        int pos = 0;
        StringBuilder res = new StringBuilder();

        String curLine;
        while ((curLine = reader.readLine()) != null) {
            if (pos < binStr.length()) {
                if (binStr.charAt(pos) == '1') {
                    curLine += " ";
                }
            }

            res.append(curLine).append("\n");
            pos++;
        }

        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String output = res.substring(0, res.length() - 1);
        writer.write(output);
        writer.close();
    }
}
