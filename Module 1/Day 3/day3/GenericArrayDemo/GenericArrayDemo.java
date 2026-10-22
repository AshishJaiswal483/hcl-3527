package day3.GenericArrayDemo;

public class GenericArrayDemo {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 30, 40};
        String[] names = {"Ashish", "Rahul", "Aman"};
        Double[] prices = {10.5, 20.5, 30.5};

        System.out.print("Numbers: ");
        printArray(numbers);

        System.out.print("Names: ");
        printArray(names);

        System.out.print("Prices: ");
        printArray(prices);
    }
}
