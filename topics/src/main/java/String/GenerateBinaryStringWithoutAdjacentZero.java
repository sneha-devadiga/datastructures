package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity : (2^n)
 * Space Complexity : O(n)
 * Leetcode Medium : 3211
 */
public class GenerateBinaryStringWithoutAdjacentZero {

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        return ans;
    }

    private void dfs(int n, StringBuilder s, List<String> ans) {
        if (n == 0) {
            ans.add(s.toString());
            return;
        }
        if (s.isEmpty() || s.charAt(s.length() - 1) == '1') {
            s.append('0');
            dfs(n-1, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
        s.append('1');
        dfs(n-1, s, ans);
        s.deleteCharAt(s.length() - 1);
    }
}
