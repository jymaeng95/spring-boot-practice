package zayson.java.lab.kotlin.basic

class Person(
    val name: String,
    var age: Int
)

fun main(args: Array<String>) {
    val person =  Person("zayson", 28)

    // 코틀린은 프로퍼티를 get할때는 .필드명으로 접근한다.
    print(person.name) // person.getName();

    // 프로퍼티를 set할 때는 대입한다.
    print(person.age)      // 28
    person.age = 30        // person.setAge(30);
    print(person.age)      // 30
}