import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=10000 ;i++){
            numbers.add(i);
        }
        System.out.println("First ArrayList Created!");
        System.out.println("Size of The First ArrayList: " + numbers.size());
        List<Integer> part1 = numbers.subList(0,2500);
        List<Integer> part2 = numbers.subList(2500,5000);
        List<Integer> part3 = numbers.subList(5000,7500);
        List<Integer> part4 = numbers.subList(7500,10000);
        System.out.println("4 ArrayLists Created! First list divided by four each one is stored in an arraylist! ");

        List<Integer> oddNumbers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> evenNumbers = Collections.synchronizedList(new ArrayList<>());
        System.out.println("2 ArrayLists Created! One for odd, the other one is for even numbers!");

        Thread t1 = new Thread(new NumberProcessor(part1, oddNumbers, evenNumbers));
        Thread t2 = new Thread(new NumberProcessor(part2, oddNumbers, evenNumbers));
        Thread t3 = new Thread(new NumberProcessor(part3, oddNumbers, evenNumbers));
        Thread t4 = new Thread(new NumberProcessor(part4, oddNumbers, evenNumbers));
        System.out.println("4 Threads created!");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The threads did their job and finished storing the numbers in 2 lists as even and odd!");
        System.out.println("Odd numbers array size: " + oddNumbers.size());
        System.out.println("Even numbers array size: " + evenNumbers.size());
    }

}