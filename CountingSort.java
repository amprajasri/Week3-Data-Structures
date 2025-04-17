public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = 18;
        int min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 14, 10, 18, 13, 11, 17, 12, 10};
        System.out.println("Ages before sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();

        countingSort(ages);

        System.out.println("Ages after sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
