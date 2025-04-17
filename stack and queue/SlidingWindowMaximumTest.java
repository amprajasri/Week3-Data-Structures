import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}

public class SlidingWindowMaximumTest {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
