package ru.batyrev.infsecuritymethods.steganography;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DoubleSpaceDecryptor extends Base {

    DoubleSpaceDecryptor(String fileName) {
        super(fileName);
    }

    String decrypt() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int pos = 0;
        StringBuilder binStr = new StringBuilder();
        List<Byte> bytes = new ArrayList<>();

        String curLine;
        boolean flag = false;
        while ((curLine = reader.readLine()) != null) {
            for (int i = 0; i < curLine.length(); i++) {
                if (curLine.charAt(i) == ' ') {
                    if (pos == 8) {
                        byte b = (byte) Integer.parseInt(binStr.toString(), 2);
                        bytes.add(b);
                        binStr = new StringBuilder();
                        pos = 0;
                    }

                    if (flag) {
                        flag = false;
                        continue;
                    }

                    if (pos < 8) {
                        if (i < curLine.length() - 1 && curLine.charAt(i + 1) == ' ') {
                            binStr.append('1');
                            pos++;
                            flag = true;
                        } else if (!flag){
                            binStr.append('0');
                            pos++;
                        }
                    }
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
