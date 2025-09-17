import java.io.*;
import java.util.Scanner;

public class BufferedFileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String src = sc.nextLine();
        System.out.print("Enter destination file path: ");
        String dest = sc.nextLine();

        try (InputStream fis = new FileInputStream(src);
             OutputStream fos = new FileOutputStream(dest)) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (end - start) + " ns");
        } catch (IOException e) {
            System.out.println(e);
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            long end = System.nanoTime();
            System.out.println("Buffered copy time: " + (end - start) + " ns");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
