package ru.batyrev.infsecuritymethods.steganography;

import java.util.HashMap;
import java.util.Map;

class CharacterMap {

    private static final Map<Character, Character> MAP = new HashMap<Character, Character>();

    static {
        MAP.put('А', 'A'); MAP.put('В', 'B');
        MAP.put('С', 'C'); MAP.put('Е', 'E');
        MAP.put('Н', 'H'); MAP.put('К', 'K');
        MAP.put('Р', 'P'); MAP.put('Т', 'T');
        MAP.put('а', 'a'); MAP.put('с', 'c');
        MAP.put('е', 'e'); MAP.put('к', 'k');
        MAP.put('о', 'o'); MAP.put('р', 'p');
        MAP.put('х', 'x'); MAP.put('у', 'y');
    }

    static Character getValue(Character key) {
        return MAP.get(key);
    }

    static boolean contains(Character value) {
        return MAP.containsValue(value);
    }
}
