package zayson.java.lab.kotlin.grammer.lecture17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lec17Main {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("apple", 1000),
                new Fruit("apple", 1200),
                new Fruit("apple", 1500),
                new Fruit("apple", 1200),
                new Fruit("banana", 3000),
                new Fruit("banana", 3200),
                new Fruit("banana", 4000),
                new Fruit("watermelon", 10000)
        );
    }

    private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        List<Fruit> results = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruitFilter.test(fruit)) {
                results.add(fruit);
            }
        }

        return fruits;
    }
}
