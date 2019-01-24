package ru.batyrev.infecuritymethods.steganography;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplaceDecryptor implements Decryptor {

    private final File container;

    public ReplaceDecryptor(File container) {
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
                for (int i = 0; i < temp.length(); i++) {
                    if (pos == 8) {
                        byteList.add((byte)Long.parseLong(binaryString.toString(), Character.MIN_RADIX));
                        binaryString = new StringBuilder();
                        pos = 0;
                    }

                    if (Dictionary.isReplaced(temp.charAt(i))) {
                        binaryString.append('1');
                        pos++;
                    } else if (Dictionary.get(temp.charAt(i)) != null) {
                        binaryString.append('0');
                        pos++;
                    }
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

