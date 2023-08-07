package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementStackUsingDeque {

    //GFG Problem

    Deque<Integer> deque;

    public ImplementStackUsingDeque(){
        deque = new LinkedList<>();
    }

    public void push(int x){
        deque.addFirst(x);
    }

    public int peek(){
        return deque.peekFirst();
    }


    public int pop(){
        return deque.removeFirst();
    }

    public boolean isEmpty(){
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingDeque obj = new ImplementStackUsingDeque();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }

}
