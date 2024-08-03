import utils.Node;

/**
 * Approach - 2 pointers (slow and fast)
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class LinkedListCycleII {
    public boolean containsCycle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
