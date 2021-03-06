package ru.batyrev.infsecuritymethods.steganography;

public class Solution {

    private static final String FILE_NAME = "text.txt";

    public static void main(String[] args) throws  Exception {
        String text = "input текст";

        ReplaceEncryptor replaceEncryptor = new ReplaceEncryptor(FILE_NAME);
        replaceEncryptor.encrypt(text);

        ReplaceDecryptor replaceDecryptor = new ReplaceDecryptor(FILE_NAME);
        String result = replaceDecryptor.decrypt();

//        SpaceEncryptor spaceEncryptor = new SpaceEncryptor(FILE_NAME);
//        spaceEncryptor.encrypt(text);
//
//        SpaceDecryptor spaceDecryptor = new SpaceDecryptor(FILE_NAME);
//        String result = spaceDecryptor.decrypt();

//        DoubleSpaceEncryptor doubleSpaceEncryptor = new DoubleSpaceEncryptor(FILE_NAME);
//        doubleSpaceEncryptor.encrypt(text);
//
//        DoubleSpaceDecryptor doubleSpaceDecryptor = new DoubleSpaceDecryptor(FILE_NAME);
//        String result = doubleSpaceDecryptor.decrypt();

        System.out.println(result);
    }
}
