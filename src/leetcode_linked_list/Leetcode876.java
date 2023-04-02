package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode876 {

    /*
    876. Middle of the Linked List
    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.
     */

    public static ListNode middleNode(ListNode head) {

        if (head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null){
            if (fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                slow = slow.next;
                return slow;
            }
        }
        return slow;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (!(fast == null || fast.next == null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        System.out.println(middleNode(head).val);
        System.out.println(middleNode(head2).val);

    }
}
