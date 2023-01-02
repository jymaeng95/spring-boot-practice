package zayson.java.lab.kotlin.grammer.lecture9;

public class JavaPerson {
    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        // 나이 검증 로직
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없다.", age));
        }

        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
