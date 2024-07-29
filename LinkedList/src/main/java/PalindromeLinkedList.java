import utils.Node;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        Node temp = null, prev = null;
        while (second != null) {
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        while (prev != null) {
            if (prev.data != head.data) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
