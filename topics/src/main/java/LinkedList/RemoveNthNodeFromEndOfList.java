package LinkedList;

import LinkedList.utils.Node;

/**
 * Approach - 2 pointers (slow and fast)
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * modified the head in place
     */
    public void delete(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        Node _1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        RemoveNthNodeFromEndOfList re = new RemoveNthNodeFromEndOfList();
        re.delete(_1, 2);
        System.out.println();

    }
}
