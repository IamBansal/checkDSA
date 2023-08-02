package leetcode_problems.sheet_arsh.linked_list;

public class MergeKSortedLists {

    /*
    23. Merge k Sorted Lists
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
     */

    //This solution uses so much time.
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode next : lists) head = mergeTwoLists(head, next);
        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    //Better solution -this solution too uses above approach kind-of,
    // but reduces the time by half as merge two lists separately,
    // not using each lists again and again.
    public static ListNode mergeKListsBetter(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private static ListNode partition(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left < right) {
            int mid = left + (right - left) / 2;
            ListNode l1 = partition(lists, left, mid);
            ListNode l2 = partition(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        } else return null;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(5))
        };
//        ListNode.printLinkedList(mergeKLists(lists));
        ListNode.printLinkedList(mergeKListsBetter(lists));
    }
}
