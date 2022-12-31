package zayson.java.lab.kotlin.grammer.lecture3

import zayson.java.lab.kotlin.grammer.lecture2.Person

fun main() {
    val number1 = 3 // Int
    val number2 = 3L // Lonng

    // 타입 변환 메서드
    val number3: Long = number1.toLong()

    // nullable 타입의 경우 safe call, elvis 연산자 이용해 적절한 처리
    val number4: Int? = 5
    val numbere5: Long = number4?.toLong() ?: 0L

    val person = Person("zayson")

    // 문자열 포맷팅
    println("이름 : ${person.name}")

    // 큰따옴표 세개 = 멀티라인 문자열 포맷팅
    val str = """
        ABC
        DEF
        ${person.name}
    """.trimIndent()

    val name = person.name
    println(name[0])
}

fun printAge(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
    }
}