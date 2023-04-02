package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode234 {

    static ListNode findMiddle(ListNode head) {
        ListNode t = head;
        if (head.next != null && head.next.next != null) t = t.next;
        return t;
    }

    static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle.next);

        ListNode start = head;
        while (second != null && start != null) {
            if (start.val != second.val) return false;
            start = start.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(head));
    }

}
