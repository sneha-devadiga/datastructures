package TwoPointers;

/**
 * Time Complexity :O(n * log(n-2)N)
 * Space Complexity : 1
 * LeectCode Medium :2396
 */
public class StrictlyPalindromicNumber {

    public boolean isStrictlyPalindromic(int n) {
        for (int k = 2; k <= n - 2; k++) if (!isStrictlyPalindromic(n, k)) return false;
        return true;
    }
    private boolean isStrictlyPalindromic(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return isPalidrome(sb);
    }

    private boolean isPalidrome(StringBuilder sb) {
        if (sb.length() == 0) return false;
        if (sb.length() == 1) return true;
        int l = 0;
        int r = sb.length()-1;

        while (l < r) if (sb.charAt(l++) != sb.charAt(r--)) return false;
        return true;
    }

}
