package day3.FailFastDemo;

import java.util.ArrayList;
import java.util.List;

public class FailFastDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        try {
            for (Integer number : numbers) {
                System.out.println(number);

                if (number == 20) {
                    numbers.remove(number);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("Final list: " + numbers);
    }
}
