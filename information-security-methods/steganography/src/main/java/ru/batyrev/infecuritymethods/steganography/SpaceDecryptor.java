package ru.batyrev.infecuritymethods.steganography;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SpaceDecryptor implements Decryptor {

    private final File container;

    public SpaceDecryptor(File container) {
        this.container = container;
    }

    @Override
    public String decrypt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(container))) {
            String temp;
            int pos = 0;
            StringBuilder binaryString = new StringBuilder();
            List<Byte> byteList = new ArrayList<>();

            while ((temp  = reader.readLine()) != null) {
                if (temp.charAt(temp.length() - 1) == ' ') {
                    binaryString.append('1');
                } else {
                    binaryString.append('0');
                }

                if (pos == 7) {
                    byteList.add((byte)Long.parseLong(binaryString.toString(), Character.MIN_RADIX));
                    binaryString = new StringBuilder();
                    pos = 0;
                } else {
                    pos++;
                }
            }

            byte[] result = new byte[byteList.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = byteList.get(i);
            }

            return new String(result);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
