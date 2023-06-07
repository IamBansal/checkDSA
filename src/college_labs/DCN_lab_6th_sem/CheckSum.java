package college_labs.DCN_lab_6th_sem;

import java.util.Scanner;

public class CheckSum {

    public static int calculateChecksum(String data) {
        int sum = 0;

        // Pad the data with zeros if its length is odd
        if (data.length() % 2 != 0) data += "0";

        // Iterate over the data in 16-bit chunks
        for (int i = 0; i < data.length(); i += 2) {
            String chunk = data.substring(i, i + 2);
            int value = Integer.parseInt(chunk, 16);
            sum += value;
        }

        // Perform one's complement on the sum
        sum = ~sum & 0xFFFF;

        return sum;
    }

    public static boolean verifyChecksum(String data, int checksum) {
        int calculatedChecksum = calculateChecksum(data);
        return calculatedChecksum == checksum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the hexa-decimal data");

        String data = sc.nextLine();
//        String data = "45000028000040004006a39e7f0000017f000001";
        int checksum = calculateChecksum(data);

        System.out.println("Data: " + data);
        System.out.println("Checksum: " + Integer.toHexString(checksum));

        boolean isValid = verifyChecksum(data, checksum);
        System.out.println("Is valid? = " + isValid);
    }
}

