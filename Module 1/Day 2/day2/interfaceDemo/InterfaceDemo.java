package day2.interfaceDemo;

interface Payment {
    void pay();
}

class UPIPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Payment p = new UPIPayment();
        p.pay();
    }
}