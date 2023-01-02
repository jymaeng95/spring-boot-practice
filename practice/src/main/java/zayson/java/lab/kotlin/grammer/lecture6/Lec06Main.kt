package zayson.java.lab.kotlin.grammer.lecture6

fun main() {
    // 컬렉션을 만드는 방법
    val numbers = listOf(1L, 2L, 3L)

    // 1. java의 for-each에서콜론 사용, 코틀린은 in을 사용
    for (number in numbers) {
        println(number)
    }

    // 2. 전통적인 for 문 (.. 범위 연산자 )
    // 올라가는 경우
    for (i in 1..3) {
        print(i)
    }

    // 내려가는 경우 (downTo -> 함수)
    for (i in 3 downTo 1) {
        print(i)
    }

    // 2씩 올라가는 경우
    for (i in 1..5 step 2) {
        print(i)
    }

}