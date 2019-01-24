package ru.batyrev.infecuritymethods.steganography;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoubleSpaceDecryptor implements Decryptor {

    private final File container;

    public DoubleSpaceDecryptor(File container) {
        this.container = container;
    }

    @Override
    public String decrypt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(container))) {
            String tmpStr;
            int iter = 0;
            StringBuilder binaryString = new StringBuilder();
            List<Byte> byteList = new ArrayList<>();
            while ((tmpStr  = reader.readLine()) != null) {
                for (int i = 0; i < tmpStr.length(); i++) {
                    if (iter == 8) {
                        byteList.add((byte)Long.parseLong(binaryString.toString(), Character.MIN_RADIX));
                        binaryString = new StringBuilder();
                        iter = 0;
                    } else {
                        //iter++;
                    }

                    if (tmpStr.charAt(i) == ' ') {
                        char c = '0';
                        if (i + 1 < tmpStr.length() && tmpStr.charAt(i + 1) == ' ') {
                            c = '1';
                        }
                        binaryString.append(c);
                    } else {
                        //binaryString.append(tmpStr.charAt(i));
                    }
                    iter++;
                }
            }
            byte[] result = new byte[byteList.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = byteList.get(i);
            }
            return new String(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Couldn't found provided file", e);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file", e);
        }
    }
}
