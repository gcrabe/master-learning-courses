package ru.batyrev.infsecuritymethods.antivirus;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DataScanner {

    public byte[] getSignature(File file) throws IOException;

    public List<String> scan(File directory, byte[] signature);
}
