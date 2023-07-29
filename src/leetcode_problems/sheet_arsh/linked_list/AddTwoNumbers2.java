package leetcode_problems.sheet_arsh.linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbers2 {

    /*
    445. Add Two Numbers II
    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    //Using recursion
    public static ListNode addTwoNumbersReverseUse(ListNode l1, ListNode l2) {
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
    
    
    
    //Answer without reversing the lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode start = new ListNode();
        ListNode temp = start;

        int carry = 0, sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            sum += carry;

            carry = sum / 10;
            answer.push(sum % 10);
            sum = 0;
        }
        if (carry != 0) answer.push(carry);

        while (!answer.isEmpty()) {
            temp.next = new ListNode(answer.pop());
            temp = temp.next;
        }

        return start.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode.printLinkedList(addTwoNumbers(one, two));
    }
}
