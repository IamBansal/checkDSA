package leetcode_problems.leetcode_recursion;

public class Question2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

    public static ListNode reverseList(ListNode head) {

        /* Solution 1

        if(head == null || head.next == null){
            return head;
        }

        ListNode result = reverseList(head.next);
        head.next = null;

        ListNode temp = result;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return result;

         */

        //Solution 2

        if (head == null || head.next == null) return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;

    }

//    public static void mergeTwoLists(ListNode list1, ListNode list2) {
//
//        Vector<Integer> v = new Vector<>();
//
//        while (list1 != null){
//           v.add(list1.val);
//            list1 = list1.next;
//        }
//
//        while (list2 != null){
//           v.add(list2.val);
//            list2 = list2.next;
//        }
//
//        sortArray(v);
//
//    }
//
//    public static void sortArray(Vector<Integer> arr){
//
//        if (arr.size() == 0 || arr.size() == 1){
//            return;
//        }
//
//        int temp = arr.elementAt(arr.size() - 1);
//
//        arr.removeElementAt(arr.size() - 1);
//        sortArray(arr);
//        insert(arr, temp);
//
//        for (Integer e: arr
//        ) {
//            System.out.print(e + " ");
//        }
//        System.out.println();
//
//    }
//
//    private static void insert(Vector<Integer> arr, int temp) {
//
//        if (arr.size() == 0 || arr.elementAt(arr.size() - 1) <= temp){
//            arr.addElement(temp);
//            return;
//        }
//
//        int val = arr.elementAt(arr.size() - 1);
//
//        arr.removeElementAt(arr.size() - 1);
//        insert(arr, temp);
//        arr.addElement(val);
//
//    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = new ListNode();
        ListNode l8 = new ListNode();

//        mergeTwoLists(l7, l8);

        ListNode result = reverseList(l1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
