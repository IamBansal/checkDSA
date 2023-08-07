package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    /*
    225. Implement Stack using Queues
    Implement a last-in-first-out (LIFO) stack using only two queues.
    The implemented stack should support all the functions of a normal stack
    (push, top, pop, and empty).

    Implement the MyStack class:
    - void push(int x) Pushes element x to the top of the stack.
    - int pop() Removes the element on the top of the stack and returns it.
    - int top() Returns the element on the top of the stack.
    - boolean empty() Returns true if the stack is empty, false otherwise.

    Notes:
    - You must use only standard operations of a queue, which means that only push to back,
      peek/pop from front, size and is empty operations are valid.
    - Depending on your language, the queue may not be supported natively.
      You may simulate a queue using a list or deque (double-ended queue)
      as long as you use only a queue's standard operations.
     */

    Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    //Queue is rotated at each push, i.e., converted to stack
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}
