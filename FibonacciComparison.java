public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30;

        long start1 = System.nanoTime();
        int result1 = fibonacciRecursive(n);
        long end1 = System.nanoTime();
        double timeRecursive = (end1 - start1) / 1e6;

        long start2 = System.nanoTime();
        int result2 = fibonacciIterative(n);
        long end2 = System.nanoTime();
        double timeIterative = (end2 - start2) / 1e6;

        System.out.println("Recursive Fibonacci (" + n + "): " + result1 + ", Time: " + timeRecursive + " ms");
        System.out.println("Iterative Fibonacci (" + n + "): " + result2 + ", Time: " + timeIterative + " ms");
    }
}
