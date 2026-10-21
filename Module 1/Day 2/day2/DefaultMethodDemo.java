interface Payment {
    void pay();

    default void showMessage() {
        System.out.println("Payment processing");
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paid through UPI");
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        UPIPayment p = new UPIPayment();

        p.pay();
        p.showMessage();
    }
}