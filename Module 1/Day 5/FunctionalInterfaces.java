import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        Function<String, Integer> getLength = text -> text.length();
        System.out.println("Length: " + getLength.apply("Java"));

        Consumer<String> printer = text -> System.out.println(text);
        printer.accept("Learning Functional Interfaces");

        Supplier<String> message = () -> "Welcome to HCL Java Training";
        System.out.println(message.get());
    }
}