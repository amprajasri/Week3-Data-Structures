import java.util.*;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            int[] data = generateRandomArray(size);

            int[] bubbleArray = Arrays.copyOf(data, data.length);
            int[] mergeArray = Arrays.copyOf(data, data.length);
            int[] quickArray = Arrays.copyOf(data, data.length);

            System.out.println("Dataset Size: " + size);

            if (size <= 10000) {
                long start = System.nanoTime();
                bubbleSort(bubbleArray);
                long end = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            long start = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long end = System.nanoTime();
            System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");

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

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}
