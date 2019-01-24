package ru.batyrev.infsecuritymethods.steganography;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class SpaceDecryptor extends Base {

    SpaceDecryptor(String fileName) {
        super(fileName);
    }

    String decrypt() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int pos = 0;
        StringBuilder binStr = new StringBuilder();
        List<Byte> bytes = new ArrayList<>();

        String curLine;
        while ((curLine = reader.readLine()) != null) {
            if (curLine.charAt(curLine.length() - 1) == ' ') {
                binStr.append('1');
            } else {
                binStr.append('0');
            }

            if (pos == 7) {
                byte b = (byte) Integer.parseInt(binStr.toString(), 2);
                bytes.add(b);
                binStr = new StringBuilder();
                pos = 0;
            } else {
                pos++;
            }
        }

        byte[] byteArray = new byte[bytes.size()];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = bytes.get(i);
        }

        return new String(byteArray, "CP1251");
    }
}
