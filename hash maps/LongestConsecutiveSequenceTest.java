import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}

public class LongestConsecutiveSequenceTest {
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        
        System.out.println("Longest consecutive sequence length: " + solution.longestConsecutive(nums));
    }
}
