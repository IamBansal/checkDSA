package leetcode_problems.sheet_arsh.linked_list;

public class ReverseLinkedList {
    
     /*
    206. Reverse Linked List
    Given the head of a singly linked list, reverse the list, and return the reversed list.
     */

    //Solution using loop
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

    //recursive solution
    public ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode result = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.printLinkedList(reverseList(head));

    }
}
