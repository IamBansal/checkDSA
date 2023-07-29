package leetcode_problems.sheet_arsh.linked_list;

public class MultiplyTwoList {

    /*
    GFG Problem

    Multiply two linked lists
    Given elements as nodes of the two linked lists.
    The task is to multiply these two linked lists, say L1 and L2.
    Note: The output could be large take modulo 109+7.
     */

    static long MOD = 1000000007;

    public static long multiplyTwoLists(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;

        while (l1 != null) {
            num1 = (num1 * 10) % MOD + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = (num2 * 10) % MOD + l2.val;
            l2 = l2.next;
        }

        return (num1 % MOD * num2 % MOD) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(multiplyTwoLists(new ListNode(6, new ListNode(4)), new ListNode(3, new ListNode(2))));
        System.out.println(multiplyTwoLists(new ListNode(1, new ListNode(0, new ListNode(0))), new ListNode(1, new ListNode(0))));
    }
}
