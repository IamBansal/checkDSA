package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode445 {

    /*
    445. Add Two Numbers II
    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contains a single digit.
     Add the two numbers and return the sum as a linked list.
     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(addTwoNumbersReverse(reverseList(l1), reverseList(l2)));
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

    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {

        ListNode start = new ListNode();
        ListNode temp = start;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {

            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return start.next;

    }

    public static void printList(ListNode result){
        do {
            System.out.print(result.val + "-> ");
            result = result.next;
        } while (result.next != null);
        System.out.print(result.val);
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));
        printList(addTwoNumbers(one, two));

    }
}
