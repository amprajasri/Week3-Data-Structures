public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {75, 88, 56, 92, 67, 80};
        System.out.println("Student Marks before Sorting:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();

        bubbleSort(marks);

        System.out.println("Student Marks after Sorting:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
