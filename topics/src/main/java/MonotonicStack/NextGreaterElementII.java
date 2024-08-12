package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * TimeComplexity : O(nums1)
 * SpaceComplexity : O(nums1)
 * LeetCode Easy : 503
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
       int n = nums.length;
       Stack<Integer> decreasing = new Stack<>();
       int[] result = new int[n];
        Arrays.fill(result, -1);
       for (int i = 0; i < n * 2; i++) {
           int val = nums[i % n];
           while (!decreasing.isEmpty() && nums[decreasing.peek()] < val) result[decreasing.pop()] = val;
           if (i < n) decreasing.add(i);
       }

       return result;
    }

}
