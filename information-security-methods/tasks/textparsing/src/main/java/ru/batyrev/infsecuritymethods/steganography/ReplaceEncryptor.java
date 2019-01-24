package ru.batyrev.infsecuritymethods.steganography;

import java.io.*;

class ReplaceEncryptor extends Base implements Encryptor {

    ReplaceEncryptor(String fileName) {
        super(fileName);
    }

    void encrypt(String inputText) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder binStr = new StringBuilder();
        byte[] byteArray = inputText.getBytes("CP1251");
        for (byte b : byteArray) {
            binStr.append(format(Integer.toBinaryString(b)));
        }

        StringBuilder res = new StringBuilder();
        int pos = 0;

        String curLine;
        while ((curLine = reader.readLine()) != null) {
            for (int i = 0; i < curLine.length(); i++) {
                Character tempChr;

                if ((tempChr = CharacterMap.getValue(curLine.charAt(i))) != null) {
                    if (pos < binStr.length()) {
                        if (binStr.charAt(pos) == '1') {
                            res.append(tempChr);
                        } else if (binStr.charAt(pos) == '0') {
                            res.append(curLine.charAt(i));
                        }

                        pos++;
                    } else {
                        res.append(curLine.charAt(i));
                    }
                } else {
                    res.append(curLine.charAt(i));
                }
            }

            res.append("\n");
        }

        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String output = res.substring(0, res.length() - 1);
        writer.write(output);
        writer.close();
    }
}
