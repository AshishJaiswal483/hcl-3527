package day1.Accessmodifiers;

class AccessExample {
    private int age = 24;
    protected String branch = "CSE AIML";
    String college = "Engineering College";
    String name = "Ashish";

    public void display() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(branch);
        System.out.println(college);
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        AccessExample obj = new AccessExample();
        obj.display();
    }
}