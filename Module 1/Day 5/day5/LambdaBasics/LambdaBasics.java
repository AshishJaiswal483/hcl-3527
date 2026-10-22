package day5.LambdaBasics;

import java.util.Arrays;
import java.util.List;

 @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

public class LambdaBasics {
    public static void main(String[] args) {
        // Lambda with two parameters
        Calculator addition = (a, b) -> a + b;
        System.out.println("Sum: " + addition.calculate(10, 20));

        // Lambda with a block body
        Calculator multiplication = (a, b) -> {
            return a * b;
        };
        System.out.println("Product: " + multiplication.calculate(5, 4));

        // Lambda with forEach
        List<String> names = Arrays.asList("Ashish", "Aman", "Sushil");
        names.forEach(name -> System.out.println(name));
    }

}