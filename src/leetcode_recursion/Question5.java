package leetcode_recursion;

public class Question5 {

    /*
    DESCRIPTION :

    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     */

    public static Question2.ListNode addTwoNumbers(Question2.ListNode l1, Question2.ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Question2.ListNode node = new Question2.ListNode();

        int sum = l1.val + l2.val;
        if (sum > 9) {
            node.val = sum % 10;
            node.next = addTwoNumber(l1.next, l2.next, sum / 10);
        } else {
            node.val = sum;
            node.next = addTwoNumber(l1.next, l2.next, 0);
        }
        return node;
    }

    private static Question2.ListNode addTwoNumber(Question2.ListNode l1, Question2.ListNode l2, int carry) {
        Question2.ListNode node = new Question2.ListNode();

        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                if (carry > 9) {
                    node.val = carry % 10;
                    node.next = addTwoNumber(null, null, carry / 10);
                } else {
                    node.val = carry;
                    node.next = addTwoNumber(null, null, 0);
                }

            }
        }

        else if (l1 == null) {
            int sum = l2.val + carry;
            if (sum > 9) {
                node.val = sum % 10;
                node.next = addTwoNumber(null, l2.next, sum / 10);
            } else {
                node.val = sum;
                node.next = addTwoNumber(null, l2.next, 0);
            }
        } else if (l2 == null) {
            int sum = l1.val + carry;
            if (sum > 9) {
                node.val = sum % 10;
                node.next = addTwoNumber(l1.next, null, sum / 10);
            } else {
                node.val = sum;
                node.next = addTwoNumber(l1.next, null, 0);
            }
        } else {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                node.val = sum % 10;
                node.next = addTwoNumber(l1.next, l2.next, sum / 10);
            } else {
                node.val = sum;
                node.next = addTwoNumber(l1.next, l2.next, 0);
            }

        }
        return node;
    }

    public static void main(String[] args) {

        Question2.ListNode l1 = new Question2.ListNode(9);
        Question2.ListNode l2 = new Question2.ListNode(9);
        Question2.ListNode l3 = new Question2.ListNode(9);

        Question2.ListNode l4 = new Question2.ListNode(9);
        Question2.ListNode l5 = new Question2.ListNode(9);
        Question2.ListNode l6 = new Question2.ListNode(9);
        Question2.ListNode l7 = new Question2.ListNode(9);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        Question2.ListNode result = addTwoNumbers(l1, l4);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}