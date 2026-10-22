package day5.StreamOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers =
                Arrays.asList(10, 20, 10, 30, 40, 50);

        // Filter, remove duplicates, sort, and collect
        List<Integer> result = numbers.stream()
                .filter(n -> n >= 20)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered: " + result);

        // Map: transform each number
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("Doubled: " + doubled);

        // Sum, minimum, maximum, and average
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: " + sum);
        System.out.println("Minimum: "
                + numbers.stream().mapToInt(Integer::intValue).min().orElse(0));
        System.out.println("Maximum: "
                + numbers.stream().mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("Average: "
                + numbers.stream().mapToInt(Integer::intValue).average().orElse(0));

        // Match operations
        System.out.println("Any above 40: "
                + numbers.stream().anyMatch(n -> n > 40));
        System.out.println("All positive: "
                + numbers.stream().allMatch(n -> n > 0));
    }
}