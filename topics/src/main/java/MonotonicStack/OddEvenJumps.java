package MonotonicStack;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> entries = new TreeMap<>();
        int[] dec = new int[n];
        int[] inc = new int[n];
        dec[n-1] = 1;
        inc[n-1] = 1;
        entries.put(arr[n-1], n-1);

        for (int i = n-2; i >= 0; --i) {
            Map.Entry<Integer, Integer> lo = entries.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> hi = entries.floorEntry(arr[i]);
            if (lo != null) inc[i] = dec[(int) lo.getValue()];
            if (hi != null) dec[i] = inc[(int )hi.getValue()];
            entries.put(arr[i], i);
        }
        return Arrays.stream(inc).sum();
    }
}
