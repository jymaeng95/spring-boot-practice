package zayson.java.lab.kotlin.grammer.lecture20

import zayson.java.lab.kotlin.grammer.lecture19.Person

fun main() {
    val person = Person("zayson", 29)
    printPerson(person)

    // let 1. 하나 이상의 함수를 call chain을 통해 결과로 호출할 때
    val strings = listOf("APPLE", "CAR", "BANANAS")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println) // List 출력

    // let 2. non-null 값에 대한 code block 실행
    val name: String? = "zayson"
    val length = name?.let {
        println(it.toUpperCase())
        it.length
    }

    // let 3. 일회성으로 제한된 영역에 지역 변수를 만드는 경우 (메서드로 빼서 만드는 것을 권장)
    val numbers = listOf("one", "two", "three", "four")
    numbers.first()
        .let { firstNumber ->
            var times = 5
            if (firstNumber.length >= 5) times = 3
            firstNumber.length * times
        }
}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
}