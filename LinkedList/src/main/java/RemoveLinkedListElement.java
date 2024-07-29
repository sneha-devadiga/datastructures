import utils.Node;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class RemoveLinkedListElement {
    public Node remove(Node head, int val) {
        Node dummy = new Node();
        dummy.next = head;

        Node prev = dummy;
        Node curr = dummy.next;
        while (curr != null) {
           if (curr.data == val) prev.next = curr.next;
           else prev = curr;
           curr = curr.next;
        }

        return dummy.next;
    }
}
