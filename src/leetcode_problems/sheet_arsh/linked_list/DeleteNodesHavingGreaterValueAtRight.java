package leetcode_problems.sheet_arsh.linked_list;

public class DeleteNodesHavingGreaterValueAtRight {

    /*
    GFG Problem

    Delete nodes having greater value on right
    Given a singly linked list, remove all the nodes which have a greater value on their right side.
     */

    public static ListNode removeNodes(ListNode head) {

        head = ReverseLinkedList.reverseList(head);
        int max = head.val;
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val < max) temp.next = temp.next.next;
            else {
                max = temp.next.val;
                temp = temp.next;
            }
        }
        return ReverseLinkedList.reverseList(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(12, new ListNode(15, new ListNode(10, new ListNode(11, new ListNode(5, new ListNode(6, new ListNode(2, new ListNode(3))))))));
        ListNode head2 = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, new ListNode(60))))));
        ListNode.printLinkedList(removeNodes(head));
        ListNode.printLinkedList(removeNodes(head2));
    }

}
