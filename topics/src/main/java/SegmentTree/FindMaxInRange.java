package SegmentTree;

/**
 * TimeComplexity:
 *    Building Segment Tree : O(n)
 *    Search and Update operation : O(logn)
 * Space Complexity: O(n)
 */
public class FindMaxInRange {
    int[] segmentTree;
    int n;
    public int max(int[] arr, int from, int to) {
        n = arr.length;
        segmentTree = new int[n * 2];
        System.arraycopy(arr, 0, segmentTree, n, n);
        for (int i = n - 1; i > 0; --i) segmentTree[i] = Math.max(segmentTree[2*i], segmentTree[2*i+1]);
        return search(from, to);
    }

    private int search(int from, int to) {
        from += n; // from is included
        to += n; // to is not included. In order to include use n+1
        int max = Integer.MIN_VALUE;

        while (from < to) {
            if ((from & 1) == 1) {
                max = Math.max(max, segmentTree[from]);
                from++;
            }
            if ((to & 1) == 1) {
                to--;
                max = Math.max(max, segmentTree[to]);
            }
            from /= 2;
            to /= 2;
        }

        return max;
    }

    public void update(int idx, int val) {
        idx += n;
        segmentTree[idx] = val;

        while (idx > 1) {
            idx /= 2;
            int newVal = Math.max(segmentTree[2*idx], segmentTree[2*idx+1]);
            if (segmentTree[idx] != newVal) segmentTree[idx] = newVal;
            else break;
        }
    }
}
