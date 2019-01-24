package ru.batyrev.infecuritymethods.steganography;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Solution {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        Encryptor replaceEncryptor = new ReplaceEncryptor(new File("container.txt"));
//        replaceEncryptor.encrypt("input текст!");
//
//        Decryptor replaceDecryptor = new ReplaceDecryptor(new File("container.txt"));
//        String replaceOut = replaceDecryptor.decrypt();
//        System.out.println("replaceOut: " + replaceOut);

        Encryptor spaceCoder = new SpaceEncryptor(new File("container.txt"));
        spaceCoder.encrypt("in_ткcт!");

        Decryptor spaceDecoder = new SpaceDecryptor(new File("container.txt"));
        String spaceOut = spaceDecoder.decrypt();
        System.out.println("spaceOut: " + spaceOut);

//        Encryptor doubleSpaceCoder = new DoubleSpaceEncryptor(new File("container.txt"));
//        doubleSpaceCoder.encrypt("in_ткcт!");
//
//        Decryptor doubleSpaceDecoder = new DoubleSpaceDecryptor(new File("container.txt"));
//        String dbSpaceOut = doubleSpaceDecoder.decrypt();
//        System.out.println("dbSpaceOut: " + dbSpaceOut);
    }
}
