package zayson.java.lab.steram;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectStream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("chaeyoung", 26),
                new Person("maeng", 30),
                new Person("joon", 28)
        );

        // 1) 이름을 리스트로 뽑기
        List<String> nameList = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("nameList = " + nameList);

        // 2) 나이를 셋으로 뽑기
        Set<Integer> ageSet = personList.stream()
                .map(Person::getAge)
                .collect(Collectors.toSet());
        System.out.println("ageSet = " + ageSet);

        // 3) 이름:나이로 맵 뽑기
        Map<String, Integer> personMapByName = personList.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("personMapByName = " + personMapByName);

        // 키가 중복인 경우 문제 에러가 발생 / BinaryOperator 이용해 덮어쓰기
        Map<Integer, String> personMapByAge = personList.stream()
                .collect(Collectors.toMap(Person::getAge, Person::getName, (oldValue, newValue) -> newValue));
        System.out.println("personMapByAge = " + personMapByAge);

        // 4) 이름을 뽑아 다양한 형태로 이어붙히기
        // 연산한 문자열을 하나의 문자열로 이어붙힌다.
        String name1 = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining());

        // 각각의 연산된 문자열에 구분자를 넣을 수 있다.
        String name2 = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining(" / "));

        // 구분자와 함께 합쳐진 문자열 앞뒤에 문자를 넣을 수 있다.
        String name3 = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining(" / ", "[", "]"));

        System.out.println("name1 = " + name1);
        System.out.println("name2 = " + name2);
        System.out.println("name3 = " + name3);

        // 5) 합계, 평균, 통계를 이용한 계산
        Integer sum1 = personList.stream().collect(Collectors.summingInt(Person::getAge));
        long sum2 = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getSum(); // 통계이용

        Double average1 = personList.stream().collect(Collectors.averagingInt(Person::getAge));
        double average2 = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getAverage();// 통계이용

        // 통계를 이용한 개수, 최대값, 최소값 구하기
        long count = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getCount();
        int maxAge = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getMax();
        int minAge = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getMin();

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("average1 = " + average1);
        System.out.println("average2 = " + average2);
        System.out.println("count = " + count);
        System.out.println("maxAge = " + maxAge);
        System.out.println("minAge = " + minAge);

        // 6) 데이터 그룹핑 (나이기준으로 데이터 그룹핑)
        Map<Integer, List<Person>> collectByAge = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("collectByAge = " + collectByAge);

        // 7) 데이터 두 부분으로 구분
        // 이름이 5글자보다 많은 경우 구분
        Map<Boolean, List<Person>> nameCollect = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getName().length() > 5));

        // 나이가 28살이 아닌 사람 구분
        Map<Boolean, List<Person>> ageCollect = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() != 28));

        System.out.println("ageCollect = " + ageCollect);
        System.out.println("nameCollect = " + nameCollect);

        personList.stream() // 스트림 생성
                .filter(person -> person.getAge() >= 28)   // 중간 연산 (나이가 28세 이하인 사람만 뽑기)
                .forEach(System.out::println);
    }
}
