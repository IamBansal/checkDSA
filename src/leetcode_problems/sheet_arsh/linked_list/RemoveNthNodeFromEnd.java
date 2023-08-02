package leetcode_problems.sheet_arsh.linked_list;

public class RemoveNthNodeFromEnd {

    /*
    19. Remove Nth Node From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode start = new ListNode();
        start.next = head;

        ListNode slow = start;
        ListNode fast = start;

        int i = 1;
        while (fast.next != null){
            if (i > n) slow = slow.next;
            fast = fast.next;
            i++;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printLinkedList(removeNthFromEnd(head, 2));
        ListNode.printLinkedList(removeNthFromEnd(new ListNode(1), 1));
        ListNode.printLinkedList(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
    }
}
