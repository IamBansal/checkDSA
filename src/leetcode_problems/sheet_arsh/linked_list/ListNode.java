package leetcode_problems.sheet_arsh.linked_list;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printLinkedList(ListNode result){
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();
    }
}
