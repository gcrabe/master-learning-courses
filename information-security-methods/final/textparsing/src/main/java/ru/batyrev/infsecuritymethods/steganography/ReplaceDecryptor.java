package ru.batyrev.infsecuritymethods.steganography;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class ReplaceDecryptor extends Base {

    ReplaceDecryptor(String fileName) {
        super(fileName);
    }

    String decrypt() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int pos = 0;
        StringBuilder binStr = new StringBuilder();
        List<Byte> bytes = new ArrayList<>();

        String curLine;
        while ((curLine = reader.readLine()) != null) {
            for (int i = 0; i < curLine.length(); i++) {
                if (pos == 8) {
                    byte b = (byte) Integer.parseInt(binStr.toString(), 2);
                    bytes.add(b);
                    binStr = new StringBuilder();
                    pos = 0;
                }

                if (CharacterMap.contains(curLine.charAt(i))) {
                    binStr.append('1');
                    pos++;
                } else if (CharacterMap.getValue(curLine.charAt(i)) != null) {
                    binStr.append('0');
                    pos++;
                }
            }
        }

        byte[] byteArray = new byte[bytes.size()];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = bytes.get(i);
        }

        return new String(byteArray, "CP1251");
    }
}