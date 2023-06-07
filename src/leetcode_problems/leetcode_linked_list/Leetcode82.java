package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode82 {

    /*
    82. Remove Duplicates from Sorted List II
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list.
    Return the linked list sorted as well.
     */

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode fakeHead = new ListNode();
        fakeHead.next = temp;
        ListNode prev = fakeHead;

        while (temp != null){

            while (temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
            }
            if (prev.next != temp){
                prev.next = temp.next;
                temp = prev.next;
            } else {
                prev = prev.next;
                temp = temp.next;
            }
        }
        return fakeHead.next;

    }

    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result2 = deleteDuplicates(head2);
        while (result2 != null) {
            System.out.print(result2.val + "-> ");
            result2 = result2.next;
        }

        System.out.println();
    }
}
