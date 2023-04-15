package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode61 {

    /*
    61. Rotate List
    Given the head of a linked list, rotate the list to the right by k places.
     */

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) return head;

        ListNode check = head;
        int length = 0;
        while (check.next != null) {
            check = check.next;
            length++;
        }

        length++;
        check.next = head;

        k = k % length;
        check = head;
        for (int i = 1; i < length - k; i++) {
            check = check.next;
        }
        head = check.next;
        check.next = null;

        return head;
    }

    public static void printList(ListNode result) {
        do {
            System.out.print(result.val + "-> ");
            result = result.next;
        } while (result.next != null);
        System.out.print(result.val);
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(rotateRight(head, 2));

        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        printList(rotateRight(head1, 4));
    }
}
