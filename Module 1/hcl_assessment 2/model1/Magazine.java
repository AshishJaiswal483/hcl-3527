
package model;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(int id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Late fee per day: Rs. 1");
    }
}
