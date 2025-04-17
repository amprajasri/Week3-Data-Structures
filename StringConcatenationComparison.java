public class StringConcatenationComparison {
    public static void main(String[] args) {
        int n = 1_000_000;
        String text = "hello";

      
        if (n <= 10000) {
            long start = System.nanoTime();
            String str = "";
            for (int i = 0; i < n; i++) {
                str += text;
            }
            long end = System.nanoTime();
            System.out.println("String time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("String concatenation skipped for large n");
        }

        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
