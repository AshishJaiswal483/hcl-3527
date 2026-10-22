package day3.wildcardDemo;

import java.util.Arrays;
import java.util.List;

public class WildcardDemo {

    // Accepts a list of any type
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    // Accepts lists of Number or its subclasses
    public static double calculateSum(List<? extends Number> numbers) {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(10, 20, 30);
        List<Double> decimals = Arrays.asList(1.5, 2.5, 3.5);
        List<String> names = Arrays.asList("Ashish", "Rahul");

        System.out.print("Integers: ");
        printList(integers);

        System.out.print("Decimals: ");
        printList(decimals);

        System.out.print("Names: ");
        printList(names);

        System.out.println("Integer sum: " + calculateSum(integers));
        System.out.println("Decimal sum: " + calculateSum(decimals));
    }
}
