public class StringBufferVsStringBuilderPerformance {

    public static void main(String[] args) {
        int count = 1_000_000;

        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + builderTime / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuffer: " + bufferTime / 1_000_000 + " ms");
    }
}
