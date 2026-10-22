package day3.GenericMethodDemo;

public class GenericMethodDemo {

    public static <T> void display(T value) {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        display(100);
        display("Ashish");
        display(12.5);
        display(true);
    }
}
