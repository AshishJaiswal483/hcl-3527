package day1.PackageDemo;

import java.util.Scanner;

public class PackageDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello, " + name);
        sc.close();
    }
}