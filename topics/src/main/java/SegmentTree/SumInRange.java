package SegmentTree;

/**
 * TimeComplexity:
 *    Building Segment Tree : O(n)
 *    Search and Update operation : O(logn)
 * Space Complexity: O(n)
 */
public class SumInRange {
    private int[] tree;
    private int n;
    public int sum(int[] arr, int from, int to) {
        n = arr.length;
        tree = new int[n*2];
        System.arraycopy(arr, 0, tree, n, n);

        for (int i = n - 1; i > 0; --i) tree[i] = tree[2*i] + tree[2*i+1];

        return sum(from, to);
    }

    private int sum(int from, int to) {
        from += n;
        to += n;
        int sum = 0;
        while (from < to) {
            if ((from & 1) == 1) {
                sum += tree[from];
                from++;
            }
            if ((to & 1) == 1) {
                --to;
                sum += tree[to];
            }
            from /= 2;
            to /= 2;
        }
        return sum;
    }
}
