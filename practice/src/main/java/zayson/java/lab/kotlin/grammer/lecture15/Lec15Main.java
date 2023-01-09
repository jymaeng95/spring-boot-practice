package zayson.java.lab.kotlin.grammer.lecture15;

import java.util.*;

public class Lec15Main {
    public static void main(String[] args) {
        int[] array = {100, 200};

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }

        // 리스트 선언
        final List<Integer> numbers = Arrays.asList(100, 200);

        // 리스트 원소 하나 접근
        System.out.println(numbers.get(0));

        // for each
        for (int n : numbers) {
            System.out.println(n);
        }

        // 전통적인 for 문
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i);
        }

        // ===== Set ====== //
        Set<Integer> set = new LinkedHashSet<>();
        set.add(100);
        set.add(200);

        Set<Integer> integers = Set.of(100, 200);
        Set<Integer> objects = Collections.emptySet();

        // ===== Map ===== //
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "zayson");
        map.put(2, "maeng");

        Map<Integer, String> nameMap = Map.of(1, "zayson", 2, "maeng");

        // Map의 키를 활용 
        for (int key : map.keySet()) {
            System.out.println("key = " + key);
            System.out.println("map.get(key) = " + map.get(key));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(" = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
        }
    }
}
