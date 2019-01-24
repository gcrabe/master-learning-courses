package ru.batyrev.infsecuritymethods.steganography;

import java.io.File;

abstract class Base {
    File file;

    Base(String fileName) {
        this.file = new File(fileName);
    }
}
