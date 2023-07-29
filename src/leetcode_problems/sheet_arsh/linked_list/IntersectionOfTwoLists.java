package leetcode_problems.sheet_arsh.linked_list;

public class IntersectionOfTwoLists {
    /*
    160. Intersection of Two Linked Lists
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));

        ListNode.printLinkedList(getIntersectionNode(one, two));
    }
}
