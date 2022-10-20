package zayson.java.lab.optional;

import zayson.java.lab.optional.model.Person;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Optional<Person> empty = Optional.empty();
        System.out.println("empty = " + empty);

    }
}
