package leetcode_problems.sheet_arsh.linked_list;

import java.util.LinkedList;
import java.util.Queue;

public class PartitionList {

    /*
    86. Partition List
    Given the head of a linked list and a value x, partition it such that all nodes
    less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
     */

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;

    }

    //Using queues
    public static ListNode partitionUsingQueue(ListNode head, int x) {

        Queue<Integer> queueSmall = new LinkedList<>();
        Queue<Integer> queueLarge = new LinkedList<>();

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) queueSmall.add(temp.val);
            else queueLarge.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (!queueSmall.isEmpty()) {
            temp.val = queueSmall.remove();
            temp = temp.next;
        }
        while (!queueLarge.isEmpty()) {
            temp.val = queueLarge.remove();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode.printLinkedList(partition(head, 3));
        ListNode.printLinkedList(partition(new ListNode(2, new ListNode(1)), 2));
    }
}
