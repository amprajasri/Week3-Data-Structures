public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 45, 89, 62, 93, 55, 70};
        System.out.println("Exam Scores before Sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
        System.out.println();

        selectionSort(examScores);

        System.out.println("Exam Scores after Sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
