package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /*
    232. Implement Queue using Stacks
    Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all
    the functions of a normal queue (push, peek, pop, and empty).

    Implement the MyQueue class:
    - void push(int x) Pushes element x to the back of the queue.
    - int pop() Removes the element from the front of the queue and returns it.
    - int peek() Returns the element at the front of the queue.
    - boolean empty() Returns true if the queue is empty, false otherwise.

    Notes:
    - You must use only standard operations of a stack, which means only push to top,
      peek/pop from top, size, and is empty operations are valid.
    - Depending on your language, the stack may not be supported natively.
      You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        stack1.push(x);
    }

    public int pop() {
        peek();
        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
