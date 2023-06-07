package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode1721 {

    /*
    1721. Swapping Nodes in a Linked List

    You are given the head of a linked list, and an integer k.
    Return the head of the linked list after swapping the values of the kth node
    from the beginning and the kth node from the end (the list is 1-indexed).

     */

    public static ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode first, second;

        for(int i = 0; i < k - 1; ++i) fast = fast.next;

        first = fast;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))));
        ListNode result = swapNodes(head, 2);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();
    }
}
