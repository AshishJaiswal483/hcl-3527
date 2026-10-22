package day3.HashMapVsTreeMap;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class HashMapVsTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(3, "Charlie");
        hashMap.put(1, "Alice");
        hashMap.put(2, "Bob");

        System.out.println("HashMap: " + hashMap);

        Map<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Charlie");
        treeMap.put(1, "Alice");
        treeMap.put(2, "Bob");

        System.out.println("TreeMap: " + treeMap);
    }
}
