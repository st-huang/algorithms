package KSum;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum_15 {
    // sort + for loop + two pointers, make sure to deduplicate for each pointer
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // deduplicate
                continue;
            }
            int lo = i + 1, hi = nums.length - 1, target = -nums[i];
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) { // deduplicate
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) { // deduplicate
                        hi--;
                    }
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return res;
    }
    // time complexity: O(n), space complexity: O(n)
}
