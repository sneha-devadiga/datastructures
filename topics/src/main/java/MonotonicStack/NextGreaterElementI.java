package MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * TimeComplexity : O(nums1)
 * SpaceComplexity : O(nums1)
 * LeetCode Easy : 496
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Map<Integer, Integer> val = new HashMap<>();
       Stack<Integer> decreasing = new Stack<>();

       for (int n : nums2) {
           while(!decreasing.isEmpty() && decreasing.peek() < n) val.put(decreasing.pop(), n);
           decreasing.add(n);
       }

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
       for (int i = 0; i < nums1.length; i++) if (val.containsKey(nums1[i])) result[i] = val.get(nums1[i]);

       return result;

    }
}
