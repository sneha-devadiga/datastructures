package String;

/**
 * TimeComplexity : O(n)
 * SpaceComplexity : O(1)
 * Leetcode Medium : 2125
 */
public class NumberOfLaserBeamsInBank {

    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prevOnes = 0;
        for (String row : bank) {
            int ones =  (int) row.chars().filter(c -> c - '0' > 0).count();
            if (ones > 0) {
                ans += prevOnes * ones;
                prevOnes = ones;
            }
        }
        return ans;
    }
}
