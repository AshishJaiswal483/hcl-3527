package day3.ListComparision;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Ashish");
        arrayList.add("Rahul");
        arrayList.add("Aman");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("Element at index 1: " + arrayList.get(1));

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("C++");

        linkedList.addFirst("C");
        linkedList.addLast("JavaScript");

        System.out.println("LinkedList: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
    }
}
