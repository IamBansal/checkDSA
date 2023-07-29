package leetcode_problems.sheet_arsh.linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206;

public class AddTwoNumbers {

    /*
    2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0, sum = 0;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            sum = 0;
        }
        if (carry != 0) temp.next = new ListNode(carry);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode.printLinkedList(addTwoNumbers(one, two));
    }
}
