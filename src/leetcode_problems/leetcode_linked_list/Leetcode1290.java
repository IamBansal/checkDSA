package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode1290 {

    /*
    1290. Convert Binary Number in a Linked List to Integer

    Given head which is a reference node to a singly-linked list.
    The value of each node in the linked list is either 0 or 1.
    The linked list holds the binary representation of a number.
    Return the decimal value of the number in the linked list.

    The most significant bit is at the head of the linked list.

     */

    public static int getDecimalValue(ListNode head) {

        if (head.next == null) return head.val;

        ListNode temp = head;
        int counter = 0;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }

        temp = head;
        int result = 0;
        while (temp != null) {
            if (temp.val == 1) result += Math.pow(2, counter);
            counter--;
            temp = temp.next;
        }

        return result;

    }

    public static int getDecimalValueBetter(ListNode head) {

        int sum = 0;
        while (head != null) {
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(getDecimalValue(head));

        ListNode head1 = new ListNode(1);
        System.out.println(getDecimalValue(head1));

        ListNode head2 = new ListNode(0);
        System.out.println(getDecimalValue(head2));
    }

}
