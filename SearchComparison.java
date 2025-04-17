import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1; // Ensure worst-case scenario (target not found)

        for (int size : sizes) {
            int[] data = generateRandomArray(size);

            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            long linearTime = end - start;

            Arrays.sort(data);
            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();
            long binaryTime = end - start;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println();
        }
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
