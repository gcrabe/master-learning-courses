package ru.batyrev.infsecuritymethods.antivirus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSystemDataScanner implements DataScanner {

    public List<String> scan(File directory, byte[] signature) {
        List<String> result = new ArrayList<>();

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                result.addAll(scan(file, signature));
            } else {
                try (RandomAccessFile accessFile = new RandomAccessFile(file, "r");
                     FileChannel channel = accessFile.getChannel()) {
                    ByteBuffer word = ByteBuffer.allocate(16);
                    word.put(Arrays.copyOfRange(signature, 0, 16));
                    word.position(0);

                    ByteBuffer buffer = ByteBuffer.allocate(16);
                    while (channel.read(buffer) != -1) {
                        buffer.position(0);
                        if (word.equals(buffer)) {
                            result.add(file.getAbsolutePath());
                        }
                        buffer.clear();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public byte[] getSignature(File file) throws IOException {
        try (RandomAccessFile accessFile = new RandomAccessFile(file, "r");
             FileChannel channel = accessFile.getChannel()) {
            byte[] signature = new byte[16];
            ByteBuffer buffer = ByteBuffer.allocate(16);

            while (channel.read(buffer) != -1) {
                System.arraycopy(buffer.array(), 0, signature, 0, buffer.array().length);
                buffer.clear();
            }

            return signature;
        }
    }
}
