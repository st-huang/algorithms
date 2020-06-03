package KSum;
import java.util.Arrays;

public class ThreeSumSmaller_259 {
    // Sort + Two pointers
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    /*
                        lo, lo + 1, ... hi - 1, hi
                        because nums[lo] + num[hi] < target - nums[i],
                        nums[lo] + nums[hi - 1] .... nums[lo] + nums[lo + 1] also < target - nums[i]
                     */
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }
}
