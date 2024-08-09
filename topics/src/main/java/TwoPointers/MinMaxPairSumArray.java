package TwoPointers;

/**
 * Time Complexity : O(nlogn)
 * Space Complexity : O(1)
 * LeetCode Medium: 1877
 */
public class MinMaxPairSumArray {
    public int minPairSum(int[] nums) {
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < j;) ans = Math.max(ans, nums[i++] + nums[j--]);
        return ans;
    }
}
