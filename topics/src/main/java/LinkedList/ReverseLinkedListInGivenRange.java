package LinkedList;

import LinkedList.utils.Node;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class ReverseLinkedListInGivenRange {

    public Node reverse(Node head, int start, int end) {

        Node first = head;
        Node last = head;
        Node prevToFirst = null;
        Node nextToLast = null;

        int counter = 0;
        while (counter++ < end) {
            if (counter < start) {
                prevToFirst =  first;
                first = first.next;
            }
            if (counter < end) {
                last = last.next;
                nextToLast = last.next;
            }
        }
        counter = end - start;
        Node temp, prev = nextToLast;
        while (counter-- > 0) {
            temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
        }
        first.next = prev;
        prevToFirst.next = first;
        return head;

    }
}
