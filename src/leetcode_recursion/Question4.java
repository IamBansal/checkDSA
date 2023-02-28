package leetcode_recursion;

public class Question4 {

    public static boolean isPalindrome(Question2.ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        Question2.ListNode slow = head;
        Question2.ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Question2.ListNode reversed = reverseList(slow.next);

        return isEqual(head, reversed);
    }

    public static boolean isEqual(Question2.ListNode list1, Question2.ListNode list2) {
        if (list1 == null) return true;
        if (list2 == null) return true;

        if (list1.val == list2.val) {
            return isEqual(list1.next, list2.next);
        } else {
            return false;
        }
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
        Question2.ListNode l3 = new Question2.ListNode(2);

        Question2.ListNode l4 = new Question2.ListNode(1);
        Question2.ListNode l5 = new Question2.ListNode(2);
        Question2.ListNode l6 = new Question2.ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;


        System.out.println(isPalindrome(l1));
    }

}
