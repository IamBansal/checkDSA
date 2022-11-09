package java_lab_5th_sem.week2;

class Node {
    int data;
    Node next;
}

class Stack {
    private Node head;

    void push(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    void pop() {
        if (head == null) {
            System.out.println("Empty stack.");
            return;
        }
        head = head.next;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }
}

class Queue {
    private Node head;

    void push(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    void pop() {
        if (head == null) {
            System.out.println("Empty Queue");
            return;
        }
        head = head.next;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }
}

public class Program6 {

    public static void main(String[] args) {

        //Stack operations
        Stack stack = new Stack();
        System.out.println("Stack : ");
        stack.push(34);
        stack.push(42);
        stack.print();
        stack.pop();
        stack.print();

        //Queue operations
        Queue queue = new Queue();
        System.out.println("\nQueue : ");
        queue.push(34);
        queue.push(42);
        queue.print();
        queue.pop();
        queue.print();

    }
}
