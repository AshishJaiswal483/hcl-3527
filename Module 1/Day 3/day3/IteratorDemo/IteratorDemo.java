package day3.IteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            int number = iterator.next();

            System.out.println(number);

            if (number == 20) {
                iterator.remove();
            }
        }

        System.out.println("After removal: " + numbers);
    }
}
