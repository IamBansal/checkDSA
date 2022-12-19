package java_lab_5th_sem.week11;

import java.io.*;

public class Program25 {

    public static void main(String[] arguments) {

        try {
            FileReader reader = new FileReader("src/a.txt");
            StringBuilder result = new StringBuilder();
            int data;
            int data2;
            while ((data = reader.read()) != -1) {
                data2 = Character.toUpperCase(data);
                result.append((char) data2);
            }
            reader.close();
            System.out.println(result);
            FileWriter writer = new FileWriter("src/a.txt");
            writer.write(result.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}