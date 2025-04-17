public class InsertionSort {
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {102, 305, 203, 401, 150, 290};
        System.out.println("Employee IDs before Sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();

        insertionSort(employeeIds);

        System.out.println("Employee IDs after Sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}
