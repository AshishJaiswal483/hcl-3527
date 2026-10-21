class BankBalance {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        BankBalance account = new BankBalance();

        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());
    }
}