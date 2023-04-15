package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode25 {

    /*
    25. Reverse Nodes in k-Group
    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.

     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy, nex, pre = dummy;

        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;

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
        printList(reverseKGroup(head, 2));
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(reverseKGroup(head1, 3));

    }
}
