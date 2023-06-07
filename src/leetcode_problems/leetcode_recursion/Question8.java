package leetcode_problems.leetcode_recursion;

public class Question8 {

    public static Question2.ListNode reorderList(Question2.ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        Question2.ListNode slow = head;
        Question2.ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Question2.ListNode reversed = reverseList(slow.next);
        slow.next = null;

        return mergeLists(head, reversed);

    }

    private static Question2.ListNode mergeLists(Question2.ListNode head, Question2.ListNode reversed) {

        if (reversed == null){
            return head;
        }

        reversed.next = mergeLists(head.next, reversed.next);
        head.next = reversed;

        return head;

    }

    public static Question2.ListNode reverseList(Question2.ListNode head) {

        if (head == null || head.next == null) return head;
        Question2.ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;

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

        Question2.ListNode result = reorderList(l1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
