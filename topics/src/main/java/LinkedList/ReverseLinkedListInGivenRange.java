package LinkedList;

import LinkedList.utils.Node;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class ReverseLinkedListInGivenRange {

    public Node reverse(Node head, int start, int end) {
        Node dummy = new Node(0, head);
        Node prev = dummy;
        for (int i = 0; i < start - 1; i++) prev = prev.next;
        Node tail = prev.next; // tail points to node at position start
        for (int i = 0; i < end - start; i++) {
            Node temp = tail.next; // holds the neighboring value of first node
            tail.next = temp.next; // breaks the link between neighboring nodes and assigns first node's
            // neighbor as second node's neighbor.
            // Since tail is not modified which is still start node -> it's next will eventually point to end's next
            temp.next = prev.next; // second nodes neighbor becomes first node
            // imagine reversing 2 nodes viz 1 -> 2 expected output 1 <- 2.
            // Only links are reversed in reversal of LL
            prev.next = temp; // this eventually points to next of end as it keeps updating
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        ReverseLinkedListInGivenRange rr = new ReverseLinkedListInGivenRange();
        Node ans = rr.reverse(head, 2, 4);
        System.out.println();
    }
}
