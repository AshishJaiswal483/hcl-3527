package day3.ArrayListOperations;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        // 1. add() - Add elements
        names.add("Ashish");
        names.add("Rahul");
        names.add("Priya");
        names.add("Rahul");
        System.out.println("Original: " + names);

        // 2. add(index, value) - Insert at a position
        names.add(1, "Amit");
        System.out.println("After insert: " + names);

        // 3. get(index) - Access an element
        System.out.println("Element at index 2: " + names.get(2));

        // 4. set(index, value) - Update an element
        names.set(0, "Rohit");
        System.out.println("After update: " + names);

        // 5. contains() - Check if an element exists
        System.out.println("Contains Priya: " + names.contains("Priya"));

        // 6. indexOf() - Find first occurrence
        System.out.println("Index of Rahul: " + names.indexOf("Rahul"));

        // 7. lastIndexOf() - Find last occurrence
        System.out.println("Last index of Rahul: " + names.lastIndexOf("Rahul"));

        // 8. size() - Count elements
        System.out.println("Size: " + names.size());

        // 9. remove(index) - Remove by index
        names.remove(1);
        System.out.println("After removing index 1: " + names);

        // 10. remove(value) - Remove first matching value
        names.remove("Rahul");
        System.out.println("After removing Rahul: " + names);

        // 11. isEmpty() - Check if list is empty
        System.out.println("Is empty: " + names.isEmpty());

        // 12. Iterate using for-each loop
        System.out.println("Using for-each:");
        for (String name : names) {
            System.out.println(name);
        }

        // 13. Iterate using traditional for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // 14. clear() - Remove all elements
        names.clear();
        System.out.println("After clear: " + names);

        // 15. Check again after clearing
        System.out.println("Is empty now: " + names.isEmpty());
    }
}