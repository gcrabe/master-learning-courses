package ru.batyrev.infsecuritymethods.antivirus;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Solution {

    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String signatureFilePath = "settings.gradle";
        File signatureFile = new File(signatureFilePath);

        String directoryPath = "C:\\temp";
        File directory = new File(directoryPath);

//        DataScanner dataScanner = new FileSystemDataScanner();
//        byte[] signature = dataScanner.getSignature(signatureFile);
//        List<String> files = dataScanner.scan(directory, signature);

        SimpleScanner simpleScanner = new SimpleScanner();
        String signature = simpleScanner.getSignature(signatureFile);
        System.out.println("signature = " + signature);
        List<String> files = simpleScanner.scan(directory, signature);

        for (String fileName : files) {
            System.out.println("Found at: " + fileName);
        }
    }

}
