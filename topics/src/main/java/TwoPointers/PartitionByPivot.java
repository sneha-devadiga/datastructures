package TwoPointers;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * LeetCode Medium : 2161
 */
public class PartitionByPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int i = 0;
        for (int n : nums) if (n < pivot) ans[i++] = n;
        for (int n : nums) if (n == pivot) ans[i++] = n;
        for (int n : nums) if (n > pivot) ans[i++] = n;

        return ans;
    }
}
