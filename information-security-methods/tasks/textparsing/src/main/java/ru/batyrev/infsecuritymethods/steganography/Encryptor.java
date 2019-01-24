package ru.batyrev.infsecuritymethods.steganography;

public interface Encryptor {

    int WORD_SIZE = 8;

    default String format(String word) {
        if (word.length() == WORD_SIZE) {
            return word;
        }

        if (word.length() > WORD_SIZE) {
            return word.substring(word.length() - WORD_SIZE);
        }

        StringBuilder res = new StringBuilder();

        while (res.length() < WORD_SIZE - word.length()) {
            res.append('0');
        }

        return res.append(word).toString();
    }
}
