package leetcode_problems.sheet_arsh.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class SortList {

    /*
    GFG Problem

    Given a linked list of 0s, 1s and 2s, sort it.
    Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
    The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side,
    2s at the end of the linked list, and 1s in the mid of 0s and 2s.
     */

    public static ListNode segregate(ListNode head) {

        ListNode temp = head;
        int counter = 0;
        while (temp != null){
            counter++;
            temp = temp.next;
        }
        temp = head;

        int[] array = new int[counter];

        int i = 0;
        while (i < counter){
            array[i] = temp.val;
            temp = temp.next;
            i++;
        }

        Arrays.sort(array);
        temp = head;
        for (int num: array){
            temp.val = num;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(0, new ListNode(2, new ListNode(0, new ListNode(1)))))));
        ListNode result = segregate(head);

        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();
    }
}
