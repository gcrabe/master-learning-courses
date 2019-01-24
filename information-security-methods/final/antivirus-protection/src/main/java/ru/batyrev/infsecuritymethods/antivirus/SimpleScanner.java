package ru.batyrev.infsecuritymethods.antivirus;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SimpleScanner {

    List<String> scan(File directory, String signature) throws IOException {
        List<String> result = new ArrayList<>();

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                result.addAll(scan(file, signature));
            } else {
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }

                if (content.indexOf(signature) != -1) {
                    result.add(file.getAbsolutePath());
                }
            }
        }

        return result;
    }

    String getSignature(File file) throws IOException {
        StringBuilder signature = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            if (signature.length() == 16) {
                break;
            }

            int pos = 0;
            while (pos < line.length() && signature.length() < 16) {
                signature.append(line.charAt(pos));
                pos++;
            }
        }

        return signature.toString();
    }
}
