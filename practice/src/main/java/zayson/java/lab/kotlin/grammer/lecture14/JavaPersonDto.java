package zayson.java.lab.kotlin.grammer.lecture14;

import java.util.Objects;

// 일반적인 자바 Dto 코드 (롬복 사용)
public class JavaPersonDto {
    private final String name;
    private final int age;

    public JavaPersonDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaPersonDto that = (JavaPersonDto) o;
        return getAge() == that.getAge() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "JavaPersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
