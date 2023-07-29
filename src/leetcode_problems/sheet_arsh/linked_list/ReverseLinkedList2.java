package leetcode_problems.sheet_arsh.linked_list;

public class ReverseLinkedList2 {

    /*
    92. Reverse Linked List II
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.
     */

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode start = new ListNode();
        start.next = head;
        ListNode leftNode = start;
        ListNode startNode = start;
        ListNode rightNode = start;

        for (int i = 1; i <= right; i++) {
            if (i <= left) {
                if (i != left) startNode = startNode.next;
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
        }

        ListNode last = rightNode.next;

        rightNode.next = null;
        startNode.next = reverseList(leftNode);
        leftNode.next = last;

        return start.next;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.printLinkedList(reverseBetween(head, 2, 4));
        ListNode head1 = new ListNode(3, new ListNode(5));
        ListNode.printLinkedList(reverseBetween(head1, 1, 2));
    }
}
