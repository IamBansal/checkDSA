package leetcode_problems.leetcode_recursion;

public class Question7 {

    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes
    (i.e., only nodes themselves may be changed.)
     */

    public static Question2.ListNode swapPairs(Question2.ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        Question2.ListNode temp = head;

        head = head.next;
        temp.next = swapPairs(head.next);
        head.next = temp;
        return head;
    }

    public static void main(String[] args) {

        Question2.ListNode l1 = new Question2.ListNode(1);
        Question2.ListNode l2 = new Question2.ListNode(2);
        Question2.ListNode l3 = new Question2.ListNode(3);
        Question2.ListNode l4 = new Question2.ListNode(4);
        Question2.ListNode l5 = new Question2.ListNode(5);
        Question2.ListNode l6 = new Question2.ListNode(6);
        Question2.ListNode l7 = new Question2.ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        Question2.ListNode result = swapPairs(l1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
