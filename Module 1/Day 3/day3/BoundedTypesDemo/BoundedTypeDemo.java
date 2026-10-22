package day3.BoundedTypesDemo;

public class BoundedTypeDemo {

    public static <T extends Number> double getDoubleValue(T number) {
        return number.doubleValue();
    }

    public static void main(String[] args) {
        Integer a = 100;
        Double b = 25.75;
        Float c = 12.5f;

        System.out.println(getDoubleValue(a));
        System.out.println(getDoubleValue(b));
        System.out.println(getDoubleValue(c));

        // This will not compile:
        // System.out.println(getDoubleValue("Java"));
    }
}
