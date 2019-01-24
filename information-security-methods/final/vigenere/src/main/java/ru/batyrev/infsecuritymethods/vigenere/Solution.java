package ru.batyrev.infsecuritymethods.vigenere;

import java.util.Scanner;

public class Solution {

    private static char[] alphabetRus = {
            'А', 'Б', 'В', 'Г', 'Д',
            'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т',
            'У', 'Ф', 'Х', 'Ц', 'Ч',
            'Ш', 'Щ', 'Ъ', 'Ы', 'Ь',
            'Э', 'Ю', 'Я'
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String key = scanner.nextLine();

//        Encryptor encryptor = new Encryptor(alphabetRus);

//        String encryption = encryptor.encrypt(input, key);
//        String output = encryptor.decrypt(encryption, key);

//        System.out.println("Encryption: " + encryption);
        System.out.println("Output: " + new Encryptor(alphabetRus).decrypt(input, key));
    }
}
