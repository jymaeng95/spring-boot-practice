package zayson.java.lab.kotlin.grammer.lecture12;

public class JavaPerson {
    private static final int MIN_AGE = 1;

    // 정적 팩토리 메서드
    public static JavaPerson newBaby(String name) {
        return new JavaPerson(name, MIN_AGE);
    }

    private String name;
    private int age;

    private JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
