package ru.batyrev.infsecuritymethods.vigenere;

public class Encryptor {

    private char[] alphabet;
    private int maxn;
    private final char[][] table;

    public Encryptor(char[] alphabet) {
        this.alphabet = alphabet;
        maxn = this.alphabet.length;

        table = new char[maxn][maxn];
        int shift = 0;

        for (int i = 0; i < maxn; i++) {
            for (int j = shift; j < maxn + shift; j++) {
                table[i][j - shift] = this.alphabet[j % maxn];
            }

            shift++;
        }
    }

    public String encrypt(String text, String key) {
        char[] textArray = text.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] result = new char[text.length()];

        for (int i = 0; i < textArray.length; i++) {
            if (Character.isSpaceChar(textArray[i])) {
                result[i] = ' ';
                continue;
            }

            int column = 0;
            int row  = 0;

            for (int j = 0; j < maxn; j++) {
                if (textArray[i] == table[0][j]) {
                    column = j;
                }
                if (keyArray[i % keyArray.length] == table[j][0]) {
                    row = j;
                }
            }

            result[i] = table[row][column];
        }

        return new String(result);
    }

    public String decrypt(String text, String key) {
        char[] textArray = text.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] result = new char[text.length()];

        for (int i = 0; i < textArray.length; i++) {
            if (Character.isSpaceChar(textArray[i])) {
                result[i] = ' ';
                continue;
            }

            int column = 0;
            int row  = 0;

            for (int j = 0; j < maxn; j++) {
                if (keyArray[i % keyArray.length] == table[j][0]) {
                    row = j;
                }
            }

            for (int j = 0; j < maxn; j++) {
                if (textArray[i] == table[row][j]) {
                    column = j;
                }
            }

            result[i] = table[0][column];
        }

        return new String(result);
    }
}
