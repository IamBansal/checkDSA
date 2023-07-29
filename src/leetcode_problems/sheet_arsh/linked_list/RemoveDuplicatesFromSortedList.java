package leetcode_problems.sheet_arsh.linked_list;

public class RemoveDuplicatesFromSortedList {

    /*
    83. Remove Duplicates from Sorted List
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    Return the linked list sorted as well.
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if (temp.val == temp.next.val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }

    public static ListNode deleteDuplicatesRecursive(ListNode head){
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result2 = deleteDuplicates(head2);
        while (result2 != null) {
            System.out.print(result2.val + "-> ");
            result2 = result2.next;
        }

        System.out.println();
    }
}
