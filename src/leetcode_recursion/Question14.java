package leetcode_recursion;

public class Question14 {

    /*
    You are given the head of a linked list.
    Remove every node which has a node with a strictly greater value anywhere to the right side of it.
    Return the head of the modified linked list.
     */
//
//    public static Question2.ListNode removeNodes(Question2.ListNode head) {
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(head.val);
//
//        Stack<Integer> result = helper(head.next, stack);
//        while (!result.isEmpty()){
//            System.out.println(stack.firstElement());
//            stack.removeElementAt(0);
//        }
//
//        return head;
//
//    }
//
//    private static Stack<Integer> helper(Question2.ListNode head, Stack<Integer> stack) {
//
//        if (stack.empty() || head == null){
//            return stack;
//        }
//
//        if (head.val > stack.peek()){
//            stack.pop();
//            if (!stack.empty() && head.val > stack.peek()){
//                return helper(head, stack);
//            } else {
//                stack.add(head.val);
//                return helper(head.next, stack);
//            }
//        } else {
//            stack.add(head.val);
//            return helper(head.next, stack);
//        }
//
//    }

    public static Question2.ListNode removeNodes(Question2.ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        Question2.ListNode l1 = new Question2.ListNode(5);
        Question2.ListNode l2 = new Question2.ListNode(2);
        Question2.ListNode l3 = new Question2.ListNode(13);
        Question2.ListNode l4 = new Question2.ListNode(3);
        Question2.ListNode l5 = new Question2.ListNode(8);
        Question2.ListNode l6 = new Question2.ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        Question2.ListNode result = removeNodes(l1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


    }

}
