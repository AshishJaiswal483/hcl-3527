package day7.F11Practice;

public class F11Practice {

    static int getSubtotal() {
        int price = 500;
        int quantity = 2;

        return price * quantity;
    }

    public static void main(String[] args) {
        int total = getSubtotal();
        System.out.println(total);
    }
}
