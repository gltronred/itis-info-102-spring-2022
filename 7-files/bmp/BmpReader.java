
import java.io.*;
import java.util.*;

public class BmpReader {
    public static int toInt(byte[] a) {
        int b = 0;
        for (int i=3; i>=0; i--) {
            b *= 256;
            b += (int)a[i];
            if (a[i] < 0) {
                b += 256;
            }
        }
        return b;
    }
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/tmp/some.bmp");

        byte[] header = new byte[18];

        int r0 = in.read(header);
        System.out.println("R0:" + r0);

        if (header[0] != 0x42 || header[1] != 0x4d ) {
            System.out.println("Not a BMP!");
            return;
        } else {
            System.out.println("BMP");

            for (int i=6; i<10; i++) {
                if (header[i] != 0) {
                    System.out.println("New BMP?");
                    return;
                }
            }

            System.out.println("Size: " + toInt(Arrays.copyOfRange(header,2,6)));

            int ver = toInt(Arrays.copyOfRange(header, 14, 18));
            System.out.println("BITMAPINFO size: " + ver);

            if (ver == 12) {
                // read 4 bytes
            } else {
                // read 8 bytes
                byte[] sizes = new byte[8];
                int r1 = in.read(sizes);
                System.out.println("read:" + r1);
                int w = toInt(Arrays.copyOfRange(sizes,0,4));
                int h = toInt(Arrays.copyOfRange(sizes,4,8));
                System.out.println(w + "x" + h);
            }

            System.out.println(Arrays.toString(header));
        }

    }
}
