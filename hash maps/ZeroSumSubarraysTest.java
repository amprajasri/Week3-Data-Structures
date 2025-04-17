import java.util.*;

class ZeroSumSubarrays {
    public List<List<Integer>> findSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum == 0) {
                result.add(Arrays.asList(0, i));
            }
            
            if (map.containsKey(sum)) {
                for (Integer start : map.get(sum)) {
                    result.add(Arrays.asList(start + 1, i));
                }
            }
            
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        
        return result;
    }
}

public class ZeroSumSubarraysTest {
    public static void main(String[] args) {
        ZeroSumSubarrays solution = new ZeroSumSubarrays();
        int[] nums = {6, -3, 2, -3, 4, -1};
        List<List<Integer>> subarrays = solution.findSubarrays(nums);
        
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
