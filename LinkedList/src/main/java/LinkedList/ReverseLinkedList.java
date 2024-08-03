package LinkedList;

import LinkedList.utils.Node;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class ReverseLinkedList {
    public Node reverse(Node head) {
        Node pointer = head;

        Node prev = null, temp = null;

        while (pointer != null) {
            temp = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = temp;
        }

        return prev;
    }
}
