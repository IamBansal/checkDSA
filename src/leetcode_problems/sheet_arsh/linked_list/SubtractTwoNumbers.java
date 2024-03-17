package leetcode_problems.sheet_arsh.linked_list;

public class SubtractTwoNumbers {

    /*
    GFG Problem

    Subtraction in Linked List
    Given two linked lists that represent two large positive numbers.
    The task is to subtract the given two numbers represented by the linked list.
    Subtract the smaller from the larger one.
     */

    public static ListNode subLinkedList(ListNode l1, ListNode l2) {

        int l1Length = 0, l2Length = 0;

        ListNode temp = l1;
        while (temp != null) {
            temp = temp.next;
            l1Length++;
        }
        temp = l2;
        while (temp != null) {
            temp = temp.next;
            l2Length++;
        }

        if (l2Length > l1Length) {
            temp = l2;
            l2 = l1;
            l1 = temp;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode result = new ListNode();
        ListNode resultF = result;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp2 != null) {

            result.next = new ListNode();
            result = result.next;
            if (temp2.val < temp1.val) {
                result.val = temp1.val - temp2.val;
                System.out.println(result.val + " at " + temp1.val + " and " + temp2.val);
            } else {

                int val = temp1.val;
                if (temp1.next != null) {
                    val += 10;
                    temp1.next.val = temp1.next.val - 1;
                }
                result.val = val - temp2.val;
                System.out.println(result.val + " at " + temp1.val + " and " + temp2.val);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            if (temp1.val < 0) {
                temp1.val += 10;
                if (temp1.next != null) temp1.next.val -= 1;
            }
            result.next = temp1;
            result = result.next;
            temp1 = temp1.next;
        }
        resultF = reverseList(resultF.next);
        while (resultF.val == 0) {
            resultF = resultF.next;
        }

        return resultF;
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(1))));
        ListNode l2 = new ListNode(1, new ListNode(2));
        ListNode.printLinkedList(subLinkedList(l1, l2));
    }
}
