package FenwickTree;

/**
 * TimeComplexity : O(logn)
 * SpaceComplexity : O(n)
 * Update TimeComplexity : O(logn)
 *
 * PrefixSumm has TimeComplexity: O(n)
 * but updating any value in prefix sum results
 * in TimeComplexity : O(n)
 */
public class FindSumInRange {
    int n;
    int[] tree;
    public int sum(int[] arr, int from, int to) {
        n = arr.length;
        tree = new int[n];
        System.arraycopy(arr, 0, tree, 0, n);

        for (int i = 1; i < n; i++) {
            int p = i + (i & -i);
            if (p < tree.length) tree[p] += tree[i];
        }

        return sum(to) - sum(--from);
    }

    private int sum(int to) {
        int sum1 = 0;
        while (to > 1) {
            sum1 += tree[to];
            to -= to & -to;
        }
        return sum1;
    }

    private int prefixSum(int[] arr, int from, int to) {
        for (int i = 1; i < arr.length; i++) arr[i] += arr[i-1];
        return arr[to] - arr[from-1];
    }

}
