package leetcode_problems.sheet_arsh.linked_list;

public class SegregateEvenOddNodes {

    /*
    GFG Problem

    Segregate even and odd nodes in a Link List
    Given a link list of size N, modify the list such that all the even numbers
    appear before all the odd numbers in the modified list.
    The order of appearance of numbers within each segregation should be same as that in the original list.

    NOTE: Don't create a new linked list, instead rearrange the provided one.
     */

    public static ListNode divide(int n, ListNode head) {
        if (n == 1) return head;

        ListNode start = new ListNode();
        start.next = head;
        ListNode last = start, prev = start, curr = start.next;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                if (last.next == curr){
                    prev = prev.next;
                    curr = curr.next;
                    last = last.next;
                } else {
                    prev.next = curr.next;
                    ListNode lastNext = last.next;
                    last.next = curr;
                    curr.next = lastNext;
                    last = curr;
                    curr = prev.next;
                }
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(divide(7, new ListNode(8, new ListNode(12, new ListNode(10, new ListNode(5, new ListNode(2, new ListNode(1, new ListNode(6)))))))));
        ListNode.printLinkedList(divide(4, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7))))));
    }
}
