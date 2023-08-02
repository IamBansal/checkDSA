package leetcode_problems.sheet_arsh.linked_list;

public class ReverseNodesInKGroups {

    /*
    25. Reverse Nodes in k-Group
    Given the head of a linked list, reverse the nodes of the list k at a time,
    and return the modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain same.

    You may not alter the values in the list's nodes, only nodes themselves may be changed.
     */

    public static ListNode reverseKGroupRecursive(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int count = k;
        ListNode start = new ListNode();
        start.next = head;
        ListNode temp = start;
        while (count > 0 && temp.next != null) {
            temp = temp.next;
            count--;
        }

        if (count != 0) return head;

        ListNode next = temp.next;
        temp.next = null;
        ListNode reversed = reverseList(head);
        head.next = reverseKGroupRecursive(next, k);
        return reversed;
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy, nex, pre = dummy;

        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
        ListNode.printLinkedList(reverseKGroup(new ListNode(1, new ListNode(2)), 2));
    }
}
