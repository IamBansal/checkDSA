package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode142 {

    /*
    142. Linked List Cycle II
    Given the head of a linked list, return the node where the cycle begins.
    If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list
    that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
    It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    Do not modify the linked list.

     */

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                ListNode entry = head;
                while (entry != slow){
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(-4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;

        System.out.println(detectCycle(head).val);
        System.out.println(detectCycle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));

    }
}
