package college_labs.DCN_lab_6th_sem;

public class GoBackNARQ {
    private static final int WINDOW_SIZE = 4; // Window size for the sender and receiver
    private static final int TIMEOUT = 3000; // Timeout value in milliseconds

    private static int base; // Sequence number of the oldest unacknowledged frame
    private static int nextSeqNum; // Sequence number of the next outgoing frame
    private static int expectedSeqNum; // Sequence number expected by the receiver

    private static boolean[] sent; // Array to track sent frames
    private static boolean[] acked; // Array to track acknowledged frames

    public static void main(String[] args) {

        int[] frames = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Sample frames to send

        base = 0;
        nextSeqNum = 0;
        expectedSeqNum = 0;

        sent = new boolean[frames.length];
        acked = new boolean[frames.length];

        // Start sender and receiver threads
        Thread senderThread = new Thread(new Sender(frames));
        Thread receiverThread = new Thread(new Receiver(frames.length));

        senderThread.start();
        receiverThread.start();

        try {
            senderThread.join();
            receiverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Sender thread
    private static class Sender implements Runnable {
        private final int[] frames;

        Sender(int[] frames) {
            this.frames = frames;
        }

        @Override
        public void run() {
            while (base < frames.length) {
                if (nextSeqNum < frames.length && (nextSeqNum < base + WINDOW_SIZE)) {
                    sendFrame(nextSeqNum);
                    nextSeqNum++;
                } else {
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void sendFrame(int frameIndex) {
            System.out.println("Sending frame: " + frames[frameIndex]);
            sent[frameIndex] = true;
        }
    }

    // Receiver thread
    private static class Receiver implements Runnable {
        private final int totalFrames;

        Receiver(int totalFrames) {
            this.totalFrames = totalFrames;
        }

        @Override
        public void run() {
            while (expectedSeqNum < totalFrames) {
                int receivedFrame = receiveFrame();
                if (receivedFrame == expectedSeqNum) {
                    System.out.println("Received frame: " + receivedFrame);
                    ackFrame(expectedSeqNum);
                    expectedSeqNum++;
                } else {
                    System.out.println("Discarding frame: " + receivedFrame);
                    ackFrame(receivedFrame - 1); // Acknowledge the last correctly received frame
                }
            }
        }

        private int receiveFrame() {
            if (Math.random() < 0.8) return expectedSeqNum;
            else return -1; // Frame loss simulation
        }

        private void ackFrame(int frameIndex) {
            System.out.println("Acknowledging frame: " + frameIndex);
            acked[frameIndex] = true;

            // Move the base if the first unacknowledged frame has been acknowledged
            while (acked[base]) base++;
        }
    }
}
