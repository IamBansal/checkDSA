package college_labs.DCN_lab_6th_sem;

import java.util.Random;

public class StopAndWaitProtocol {
    private static final int TIMEOUT = 3000;

    private static void simulateNetworkDelay() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Sender {
        private boolean ackReceived = false;

        public void sendPacket(int packet) {
            System.out.println("Sender: Sending packet " + packet);
            simulateNetworkDelay();
            boolean packetLost = new Random().nextBoolean();
            if (packetLost) {
                System.out.println("Sender: Packet " + packet + " lost!");
                return;
            }

            boolean ackLost = new Random().nextBoolean();
            if (ackLost) {
                System.out.println("Sender: ACK for packet " + packet + " lost!");
                return;
            }

            ackReceived = true;
            System.out.println("Sender: ACK received for packet " + packet);
        }

        public boolean isAckReceived() {
            return ackReceived;
        }
    }

    static class Receiver {
        public void receivePacket(int packet) {
            System.out.println("Receiver: Received packet " + packet);
            simulateNetworkDelay();

            boolean ackLost = new Random().nextBoolean();
            if (ackLost) {
                System.out.println("Receiver: ACK for packet " + packet + " lost!");
                return;
            }
            System.out.println("Receiver: Sending ACK for packet " + packet);
        }
    }

    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        int totalPackets = 5;

        for (int i = 0; i < totalPackets; i++) {
            sender.sendPacket(i);
            long startTime = System.currentTimeMillis();

            while (!sender.isAckReceived()) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - startTime > TIMEOUT) {
                    System.out.println("Sender: Timeout occurred for packet " + i);
                    break;
                }
            }

            receiver.receivePacket(i);
            sender.ackReceived = false;
        }
    }
}