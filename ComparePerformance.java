import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ComparePerformance {

    public static void main(String[] args) {
        testStringConcatenation();
        testFileReading();
    }

    public static void testStringConcatenation() {
        long startTime, endTime;
        String str = "hello";
        int iterations = 1000000;

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " nanoseconds");
    }

    public static void testFileReading() {
        String filePath = "audition.txt";

        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            int wordCount = countWords(br);
            long endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) + " nanoseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            int wordCount = countWords(br);
            long endTime = System.nanoTime();
            System.out.println("BufferedReader word count: " + wordCount);
            System.out.println("BufferedReader time: " + (endTime - startTime) + " nanoseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            wordCount += st.countTokens();
        }
        return wordCount;
    }
}
