package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if (target % 2 != 0) return false;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int n : nums) {
            Set<Integer> set1 = new HashSet<>();
            for (int m : set) {
                set1.add(n + m);
                set1.add(n);
            }
            set = set1;
        }
        return set.contains(target/2);
    }
}
