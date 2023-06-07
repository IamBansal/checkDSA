package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode86 {

    /*
    86. Partition List
    Given the head of a linked list and a value x, partition it such that all nodes less than x
     come before nodes greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.
     */

    public static ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(5, new ListNode(2)))))));
        ListNode result = partition(head, 3);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();


        ListNode head1 = new ListNode(2, new ListNode(1));
        ListNode result1 = partition(head1, 2);
        while (result1 != null) {
            System.out.print(result1.val + "-> ");
            result1 = result1.next;
        }

        System.out.println();
    }
}
