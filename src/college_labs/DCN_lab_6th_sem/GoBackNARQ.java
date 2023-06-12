package college_labs.DCN_lab_6th_sem;

import java.util.Random;
import java.util.Scanner;

public class GoBackNARQ {
//    private static final int WINDOW_SIZE = 4; // Window size for the sender and receiver
//    private static final int TIMEOUT = 3000; // Timeout value in milliseconds
//
//    private static int base; // Sequence number of the oldest unacknowledged frame
//    private static int nextSeqNum; // Sequence number of the next outgoing frame
//    private static int expectedSeqNum; // Sequence number expected by the receiver
//
//    private static boolean[] sent; // Array to track sent frames
//    private static boolean[] acked; // Array to track acknowledged frames
//
//    public static void main(String[] args) {
//
//        int[] frames = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Sample frames to send
//
//        base = 0;
//        nextSeqNum = 0;
//        expectedSeqNum = 0;
//
//        sent = new boolean[frames.length];
//        acked = new boolean[frames.length];
//
//        // Start sender and receiver threads
//        Thread senderThread = new Thread(new Sender(frames));
//        Thread receiverThread = new Thread(new Receiver(frames.length));
//
//        senderThread.start();
//        receiverThread.start();
//
//        try {
//            senderThread.join();
//            receiverThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Sender thread
//    private static class Sender implements Runnable {
//        private final int[] frames;
//
//        Sender(int[] frames) {
//            this.frames = frames;
//        }
//
//        @Override
//        public void run() {
//            while (base < frames.length) {
//                if (nextSeqNum < frames.length && (nextSeqNum < base + WINDOW_SIZE)) {
//                    sendFrame(nextSeqNum);
//                    nextSeqNum++;
//                } else {
//                    try {
//                        Thread.sleep(TIMEOUT);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//        private void sendFrame(int frameIndex) {
//            System.out.println("Sending frame: " + frames[frameIndex]);
//            sent[frameIndex] = true;
//        }
//    }
//
//    // Receiver thread
//    private static class Receiver implements Runnable {
//        private final int totalFrames;
//
//        Receiver(int totalFrames) {
//            this.totalFrames = totalFrames;
//        }
//
//        @Override
//        public void run() {
//            while (expectedSeqNum < totalFrames) {
//                int receivedFrame = receiveFrame();
//                if (receivedFrame == expectedSeqNum) {
//                    System.out.println("Received frame: " + receivedFrame);
//                    ackFrame(expectedSeqNum);
//                    expectedSeqNum++;
//                } else {
//                    System.out.println("Discarding frame: " + receivedFrame);
//                    ackFrame(receivedFrame - 1); // Acknowledge the last correctly received frame
//                }
//            }
//        }
//
//        private int receiveFrame() {
//            if (Math.random() < 0.8) return expectedSeqNum;
//            else return -1; // Frame loss simulation
//        }
//
//        private void ackFrame(int frameIndex) {
//            System.out.println("Acknowledging frame: " + frameIndex);
//            acked[frameIndex] = true;
//
//            // Move the base if the first unacknowledged frame has been acknowledged
//            while (acked[base]) base++;
//        }
//    }
//
//    static class Frame {
//        private int sequenceNumber;
//        private String data;
//
//        public Frame(int sequenceNumber, String data) {
//            this.sequenceNumber = sequenceNumber;
//            this.data = data;
//        }
//
//        public int getSequenceNumber() {
//            return sequenceNumber;
//        }
//
//        public String getData() {
//            return data;
//        }
//    }
//
//    static class Sender {
//        private int windowSize;
//        private Frame[] frames;
//        private int nextSequenceNumber;
//        private int base;
//        private Timer timer;
//
//        public Sender(int windowSize) {
//            this.windowSize = windowSize;
//            frames = new Frame[windowSize];
//            nextSequenceNumber = 0;
//            base = 0;
//        }
//
//        public void sendData(String data) {
//            if (nextSequenceNumber < base + windowSize) {
//                Frame frame = new Frame(nextSequenceNumber, data);
//                frames[nextSequenceNumber % windowSize] = frame;
//                System.out.println("Sender: Sending frame " + nextSequenceNumber + ": " + data);
//                sendFrame(frame);
//
//                if (base == nextSequenceNumber) {
//                    startTimer();
//                }
//
//                nextSequenceNumber++;
//            } else {
//                System.out.println("Sender: Window is full. Waiting for ACKs...");
//            }
//        }
//
//        private void sendFrame(Frame frame) {
//            // Simulated sending of frame over the network
//            // You can replace this with your own network transmission logic
//        }
//
//        private void startTimer() {
//            timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println("Sender: Timer expired. Resending frames from " + base + " to " + (nextSequenceNumber - 1));
//                    for (int i = base; i < nextSequenceNumber; i++) {
//                        sendFrame(frames[i % windowSize]);
//                    }
//                    startTimer();
//                }
//            }, 2000); // Timer duration (e.g., 2000 milliseconds)
//        }
//
//        public void receiveACK(int ack) {
//            System.out.println("Sender: Received ACK " + ack);
//
//            if (base <= ack) {
//                base = ack + 1;
//                if (base == nextSequenceNumber) {
//                    stopTimer();
//                } else {
//                    stopTimer();
//                    startTimer();
//                }
//            } else {
//                System.out.println("Sender: Discarding duplicate ACK");
//            }
//        }
//
//        private void stopTimer() {
//            if (timer != null) {
//                timer.cancel();
//                timer = null;
//            }
//        }
//    }
//
//    static class Receiver {
//        private int expectedSequenceNumber;
//
//        public Receiver() {
//            expectedSequenceNumber = 0;
//        }
//
//        public void receiveFrame(Frame frame) {
//            System.out.println("Receiver: Received frame " + frame.getSequenceNumber() + ": " + frame.getData());
//
//            if (frame.getSequenceNumber() == expectedSequenceNumber) {
//                System.out.println("Receiver: Sending ACK " + expectedSequenceNumber);
//                sendACK(expectedSequenceNumber);
//                expectedSequenceNumber++;
//            } else {
//                System.out.println("Receiver: Discarding out-of-order frame");
//                sendACK(expectedSequenceNumber - 1);
//            }
//        }
//
//        private void sendACK(int ack) {
//            // Simulated sending of ACK over the network
//            // You can replace this with your own network transmission logic
//
//            // Assuming the ACK is transmitted successfully
//            // In practice, ACKs can also be lost or corrupted
//            Sender sender = new Sender(0);
//            sender.receiveACK(ack);
//        }
//    }
//        public static void main(String[] args) {
//            Sender sender = new Sender(4);
//            Receiver receiver = new Receiver();
//
//            // Simulating sending data from the sender
//            for (int i = 1; i <= 5; i++) sender.sendData("Frame " + i);
//
//            // Simulating receiving frames at the receiver
//            receiver.receiveFrame(new Frame(0, "Frame 1"));
//            receiver.receiveFrame(new Frame(1, "Frame 2"));
//            receiver.receiveFrame(new Frame(2, "Frame 4"));
//            receiver.receiveFrame(new Frame(3, "Frame 5"));
//            receiver.receiveFrame(new Frame(4, "Frame 3"));
//        }
        public static void transmission(int i, int N, int tf, int[] tt) {
            while (i <= tf) {
                int z = 0;
                for (int k = i; k < i + N && k <= tf; k++) {
                    System.out.println("Sending Frame " + k + "...");
                    tt[0]++;
                }
                for (int k = i; k < i + N && k <= tf; k++) {
                    int f = new Random().nextInt(2);
                    if (f != 0) {
                        System.out.println("Acknowledgment for Frame " + k + "...");
                        z++;
                    } else {
                        System.out.println("Timeout!! Frame Number: " + k + " Not Received");
                        System.out.println("Retransmitting Window...");
                        break;
                    }
                }
                System.out.println();
                i = i + z;
            }
        }

        public static void main(String[] args) {
            int tf, N;
            int[] tt = {0};
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the Total number of frames: ");
            tf = scanner.nextInt();
            System.out.print("Enter the Window Size: ");
            N = scanner.nextInt();
            int i = 1;

            transmission(i, N, tf, tt);

            System.out.println("Total number of frames which were sent and resent are: " + tt[0]);
        }
    }