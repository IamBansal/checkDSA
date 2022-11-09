package java_lab_5th_sem.week7;

import java.util.LinkedList;

public class Program18 {

    public static class PC {

        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    //producer thread waits while list is full
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced:"
                            + value);

                    //to insert the jobs in the list
                    list.add(value++);

                    //notifies the consumer thread that now it can start consuming
                    notify();

                    //makes the working of program easier to  understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    //consumer thread waits while list is empty
                    while (list.size() == 0)
                        wait();

                    //to retrieve the first job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed:" + val);

                    //Wake up producer thread
                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final PC pc = new PC();

        // Create producer thread
        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}