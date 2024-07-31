import utils.Node;

/**
 * Time Complexity : O(l1.size + l2.size)
 * Space Complexity : O(l1.size + l2.size)
 */
public class MergeTwoSortedLinkedList {

    public Node merge(Node list1, Node list2) {
        Node dummy = new Node();
        Node prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        if (list1 != null) prev.next = list1;

        if (list2 != null) prev.next = list2;

        return dummy.next;
    }

}