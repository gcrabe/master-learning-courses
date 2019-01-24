import java.util.zip.CRC32;

public class Solution {

    static int calc(byte[] data) {
        int [] crc_table = new int[256];
        int crc;

        for (int i = 0; i < 256; i++)
        {
            crc = i;
            for (int j = 0; j < 8; j++)
                crc = (crc % 2 != 0) ? (crc >>> 1) ^ 0xEDB88320 : crc >>> 1;
            crc_table[i] = crc;
        }

        crc = 0xFFFFFFFF;

        for (byte b : data) {
            crc = (crc >>> 8) ^ crc_table[(crc ^ b) & 0xFF];
        }

        return crc ^ 0xFFFFFFFF;
    }

    public static void main(String[] args) {
        String input = "123456789";

        byte[] bytes = input.getBytes();

        int res = calc(bytes);

        System.out.println("CRC32 = " + Integer.toHexString(res));
    }
}
