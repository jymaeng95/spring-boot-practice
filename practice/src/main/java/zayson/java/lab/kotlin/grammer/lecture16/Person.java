package zayson.java.lab.kotlin.grammer.lecture16;

public class Person {
    private final String firstName;
    private final String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // 멤버함수
    public int nextYearAge() {
        System.out.println("자바의 멤버 함수");
        return this.age + 1;
    }
}

