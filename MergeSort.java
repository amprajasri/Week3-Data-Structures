public class MergeSort {
    public static void mergeSort(int[] prices) {
        if (prices.length <= 1) {
            return;
        }

        int mid = prices.length / 2;
        int[] left = new int[mid];
        int[] right = new int[prices.length - mid];

        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(prices, left, right);
    }

    public static void merge(int[] prices, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }

        while (i < left.length) {
            prices[k++] = left[i++];
        }

        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] bookPrices = {299, 149, 499, 199, 349, 129};
        System.out.println("Book Prices before Sorting:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
        System.out.println();

        mergeSort(bookPrices);

        System.out.println("Book Prices after Sorting:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}
