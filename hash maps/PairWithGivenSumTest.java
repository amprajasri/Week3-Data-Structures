import java.util.HashSet;

class PairWithGivenSum {
    public boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }
}

public class PairWithGivenSumTest {
    public static void main(String[] args) {
        PairWithGivenSum solution = new PairWithGivenSum();
        int[] nums = {10, 15, 3, 7};
        int target = 17;
        
        if (solution.hasPairWithSum(nums, target)) {
            System.out.println("Pair found with sum " + target);
        } else {
            System.out.println("No pair found with sum " + target);
        }
    }
}
