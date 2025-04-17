public class SearchFirstNegativeNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, -2, 5, 6, -7, 8};
        int result = findFirstNegativeNumber(arr);
        System.out.println(result);  // Output: 2
    }

    public static int findFirstNegativeNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
