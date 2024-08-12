package MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementIV {

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
       Stack<Integer> prevStack = new Stack<>();
       Stack<Integer> currStack = new Stack<>();

       int[] result = new int[n];
       Arrays.fill(result, -1);

       for (int i = 0; i < n; ++i) {
           while (!prevStack.isEmpty() && nums[prevStack.peek()] < nums[i]) result[prevStack.pop()] = nums[i];

           Stack<Integer> decreasingIdx = new Stack<>();
           while (!currStack.isEmpty() && nums[currStack.peek()] < nums[i]) decreasingIdx.add(currStack.pop());
           while (!decreasingIdx.isEmpty()) prevStack.add(decreasingIdx.pop());
           currStack.add(i);
       }
       return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,0,9,6};
        NextGreaterElementIV nextGreaterElementIV = new NextGreaterElementIV();
        System.out.println(Arrays.toString(nextGreaterElementIV.secondGreaterElement(nums)));
    }
}
