package leetcode_problems.sheet_arsh.stacks_queues;

public class ImplementTwoStacksInAnArray {

    /*
    GFG Problem

    Implement two stacks in an array
    Your task is to implement  2 stacks in one array efficiently. You need to implement 4 methods.
    - push1 : pushes element into first stack.
    - push2 : pushes element into second stack.
    - pop1 : pops element from first stack and returns the popped element.
      If first stack is empty, it should return -1.
    - pop2 : pops element from second stack and returns the popped element.
      If second stack is empty, it should return -1.
     */

    int[] arr;
    int size;
    int top1, top2;

    ImplementTwoStacksInAnArray() {
        size = 100;
        arr = new int[100];
        top1 = 0;
        top2 = size - 1;
    }

    //Function to push an integer into the stack1.
    void push1(int x) {
        arr[top1] = x;
        top1++;
    }

    //Function to push an integer into the stack2.
    void push2(int x) {
        arr[top2] = x;
        top2--;
    }

    //Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 <= 0) return -1;
        top1--;
        return arr[top1];
    }

    //Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 >= 99) return -1;
        top2++;
        return arr[top2];
    }

    public static void main(String[] args) {
        ImplementTwoStacksInAnArray obj = new ImplementTwoStacksInAnArray();
        obj.push1(2);
        obj.push1(3);
        obj.push2(4);

        for (int nums: obj.arr) System.out.print(nums + " ");
        System.out.println();

        obj.pop1();
        obj.pop2();
        obj.pop2();
    }

}
