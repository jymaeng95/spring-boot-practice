package zayson.java.lab.stream;

import java.util.ArrayList;
import java.util.List;

public class PeekStream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("caheyoung", 26),
                new Person("maeng", 30),
                new Person("joon", 32)
        );

        List<String> nameList = new ArrayList<>();
        personList.stream()
                .limit(2)       // 데이터 2개 제한
                .map(Person::getName)   // 이름만 가져와서 String Stream 변환
                .peek(nameList::add) // 나온 이름 2개 리스트에 추가
                .filter(name -> name.startsWith("z")) // z로 시작하는 문자
                .forEach(System.out::println); // 출력

        System.out.println("nameList.size() = " + nameList.size());
    }
}
