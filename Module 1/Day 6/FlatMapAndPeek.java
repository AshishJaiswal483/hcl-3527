import java.util.Arrays;
import java.util.List;

public class FlatMapAndPeek {
    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        numbers.stream()
                .flatMap(List::stream)
                .peek(n -> System.out.println("Before filter: " + n))
                .filter(n -> n > 4)
                .peek(n -> System.out.println("After filter: " + n))
                .forEach(n -> System.out.println("Final: " + n));
    }
}