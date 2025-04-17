import java.io.*;

public class FileReadEfficiency {
    public static void main(String[] args) throws Exception {
        String filePath = "audition.txt";

        long start1 = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1) {}
        }
        long end1 = System.nanoTime();
        double timeFileReader = (end1 - start1) / 1e6;

        long start2 = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {}
        }
        long end2 = System.nanoTime();
        double timeInputStreamReader = (end2 - start2) / 1e6;

        System.out.println("FileReader time: " + timeFileReader + " ms");
        System.out.println("InputStreamReader time: " + timeInputStreamReader + " ms");
    }
}
