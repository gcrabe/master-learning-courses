package ru.batyrev.infsecuritymethods.vigenere;

import java.util.ArrayList;

class Encryptor {

    private char[] ALPHABET;
    private int MAXN;
    private char[][] TABLE;

    Encryptor(char[] ALPHABET) {
        this.ALPHABET = ALPHABET;
        MAXN = this.ALPHABET.length;

        TABLE = new char[MAXN][MAXN];
        int pos = 0;

        for (int i = 0; i < MAXN; i++) {
            for (int j = pos; j < MAXN + pos; j++) {
                TABLE[i][j - pos] = this.ALPHABET[j % MAXN];
            }

            pos++;
        }

//        for (int i = 0; i < MAXN; i++) {
//            for (int j = 0; j < MAXN; j++) {
//                System.out.print(String.valueOf(TABLE[i][j]) + ' ');
//            }
//            System.out.println();
//        }
    }

    private ArrayList<Character> getRowByLetter(char c) {
        ArrayList<Character> res = new ArrayList<Character>();

        for (int i = 0; i < MAXN; i++) {
            if (TABLE[i][0] == c) {
                for (int j = 0; j < MAXN; j++) {
                    res.add(TABLE[i][j]);
                }
                return res;
            }
        }

        return null;
    }

    private boolean inAlpabet(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return true;
            }
        }

        return false;
    }

    String encrypt(String text, String key) {
        ArrayList<ArrayList<Character>> table = new ArrayList<ArrayList<Character>>();
        table.add(getRowByLetter('А'));

        for (int i = 0; i < key.length(); i++) {
            table.add(getRowByLetter(key.charAt(i)));
        }

//        for (ArrayList<Character> line : table) {
//            for (Character c : line) {
//                System.out.print(c.toString() + ' ');
//            }
//            System.out.println();
//        }

        StringBuilder cycleKey = new StringBuilder();
        int pos = 0;
        for (Character chr : text.toCharArray()) {
            if (!inAlpabet(chr)) {
                cycleKey.append(chr);
                continue;
            }

            if (pos >= key.length()) {
                pos = 0;
            }

            cycleKey.append(key.charAt(pos));
            pos++;
        }

//        System.out.println(cycleKey);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (!inAlpabet(text.charAt(i))) {
                res.append(text.charAt(i));
                continue;
            }

            Character charIndexJ = text.charAt(i);
            Character charIndexI = cycleKey.charAt(i);

            char temp = '-';

            for (int it = 0; it < table.size(); it++) {
                if (table.get(it).get(0).equals(charIndexI)) {
                    for (int jt = 0; jt < table.get(it).size(); jt++) {
                        if (table.get(0).get(jt).equals(charIndexJ)) {
                            temp = table.get(it).get(jt);
                        }
                    }
                }
            }

            res.append(temp);
        }

        return res.toString();
    }

    String decrypt(String text, String key) {
        ArrayList<ArrayList<Character>> table = new ArrayList<ArrayList<Character>>();
        table.add(getRowByLetter('А'));

        for (int i = 0; i < key.length(); i++) {
            table.add(getRowByLetter(key.charAt(i)));
        }

//        for (ArrayList<Character> line : table) {
//            for (Character c : line) {
//                System.out.print(c.toString() + ' ');
//            }
//            System.out.println();
//        }

        StringBuilder cycleKey = new StringBuilder();
        int pos = 0;
        for (Character chr : text.toCharArray()) {
            if (!inAlpabet(chr)) {
                cycleKey.append(chr);
                continue;
            }

            if (pos >= key.length()) {
                pos = 0;
            }

            cycleKey.append(key.charAt(pos));
            pos++;
        }

//        System.out.println(cycleKey);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (!inAlpabet(text.charAt(i))) {
                res.append(text.charAt(i));
                continue;
            }

            Character charIndexJ = text.charAt(i);
            Character charIndexI = cycleKey.charAt(i);

            char temp = '-';

            for (int it = 0; it < table.size(); it++) {
                if (table.get(it).get(0).equals(charIndexI)) {
                    for (int jt = 0; jt < table.get(it).size(); jt++) {
                        if (table.get(it).get(jt).equals(charIndexJ)) {
                            temp = table.get(0).get(jt);
                        }
                    }
                }
            }

            res.append(temp);
        }

        return res.toString();
    }
}
