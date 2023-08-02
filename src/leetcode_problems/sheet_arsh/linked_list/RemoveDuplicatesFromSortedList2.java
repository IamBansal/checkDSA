package leetcode_problems.sheet_arsh.linked_list;

public class RemoveDuplicatesFromSortedList2 {

    /*
    82. Remove Duplicates from Sorted List II
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list. Return the linked list sorted as well.
     */

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode fakeHead = new ListNode();
        fakeHead.next = temp;
        ListNode prev = fakeHead;

        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            if (prev.next != temp) {
                prev.next = temp.next;
                temp = prev.next;
            } else {
                prev = prev.next;
                temp = temp.next;
            }
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode.printLinkedList(deleteDuplicates(head));
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode.printLinkedList(deleteDuplicates(head1));
    }
}
