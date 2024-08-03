package String;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Leetcode Medium : 1689
 */
public class PartitioningIntoMinNumOfDeciBinaryNumber {

    public int min(String str) {
        int val = 0;
        for (char c : str.toCharArray()) val = Math.max(val, c - '0');
        return val;
    }
}
