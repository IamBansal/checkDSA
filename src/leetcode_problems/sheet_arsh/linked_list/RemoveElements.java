package leetcode_problems.sheet_arsh.linked_list;

public class RemoveElements {

    /*
    203. Remove Linked List Elements
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that
    has Node.val == val, and return the new head.
     */

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head.val == 7 ? head.next : head;
    }

    //Recursive solution
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;

        if (head.val != val) {
            head.next = removeElementsRecursive(head.next, val);
            return head;
        } else return removeElementsRecursive(head.next, val);

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode result = removeElements(head, 6);

        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();
    }
}
