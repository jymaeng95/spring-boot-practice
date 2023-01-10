package zayson.java.lab.kotlin.grammer.lecture16

fun Int.add(number: Int) = this + number

infix fun Int.addInfix(number: Int) = this + number

fun main() {
    // 일반 확장함수 호출
    println(5.add(10))

    // 중위함수 호출 2가지 방법
    println(5.addInfix(10))
    println(5 addInfix 10)

    // 인라임 함수 호출
    5.add3(10)
}

inline fun Int.add3(number: Int) = this + number