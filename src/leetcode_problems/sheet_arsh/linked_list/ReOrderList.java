package leetcode_problems.sheet_arsh.linked_list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReOrderList {

    /*
    143. Reorder List
    You are given the head of a singly linked-list. The list can be represented as:
    - L0 → L1 → … → Ln - 1 → Ln

    Reorder the list to be on the following form:
    - L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     */

    //This solution changes the values of the nodes - which is not desirable.
    public static ListNode reorderListByChangingValues(ListNode head) {
        if (head.next == null) return head;

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            queue.add(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.val = queue.remove();
            temp = temp.next;
            if (temp != null) {
                temp.val = stack.pop();
                temp = temp.next;
            }
        }
        return head;
    }


    //Desired solution - changing nodes themselves
    public static ListNode reorderList(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverseList(slow.next);
        slow.next = null;

        return mergeLists(head, reversed);
    }

    private static ListNode mergeLists(ListNode head, ListNode reversed) {

        if (reversed == null) return head;
        reversed.next = mergeLists(head.next, reversed.next);
        head.next = reversed;

        return head;
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        ListNode.printLinkedList(reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
