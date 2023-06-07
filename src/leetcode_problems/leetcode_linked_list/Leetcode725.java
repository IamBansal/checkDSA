package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode725 {

    /*
    725. Split Linked List in Parts
    Given the head of a singly linked list and an integer k,
    split the linked list into k consecutive linked list parts.
    The length of each part should be as equal as possible:
    no two parts should have a size differing by more than one.
    This may lead to some parts being null.
    The parts should be in the order of occurrence in the input list,
    and parts occurring earlier should always have a size greater than or equal to parts occurring later.

    Return an array of the k parts.
     */

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next) len++;
        int n = len / k, r = len % k;
        ListNode node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            assert prev != null;
            prev.next = null;
        }
        return parts;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))));
        ListNode[] result = splitListToParts(head, 2);

    }

}