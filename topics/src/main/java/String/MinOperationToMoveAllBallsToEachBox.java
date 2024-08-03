package String;

import java.util.Arrays;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Leetcode Medium : 1769
 */
public class MinOperationToMoveAllBallsToEachBox {
    String boxes;
    int n;
    public int[] minOperations(String boxes) {
        this.boxes = boxes;
        n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') recursion(i, 0, ans, new boolean[n]);
        }
        return ans;
    }

    private void recursion(int i, int moves, int[] ans, boolean[] visited) {
        if (i < 0 || i == n || visited[i]) return;
        ans[i] += moves;
        visited[i] = true;
        recursion(i-1, moves + 1, ans, visited);
        recursion(i+1, moves + 1, ans, visited);
    }
}
