package zayson.java.lab.kotlin.basic

import zayson.java.lab.kotlin.basic.Color.*
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val color = getColor(INDIGO)
    println(color)

    val warmth = getWarmth(YELLOW)
    println("warmth = ${warmth}")

    val mix = getMix(RED, YELLOW)
    println("mix = ${mix}")

    val refactorMix = refactorGetMix(RED, YELLOW)
    println("refactorMix = ${refactorMix}")
}

// Enum을 이용한 Switch
fun getColor(color: Color): String {
    // when은 Java의 Switch문이다.
    return when (color) {
        RED -> "빨"
        ORANGE -> "주"
        YELLOW -> "노"
        GREEN -> "초"
        BLUE -> "파"
        INDIGO -> "남"
        VIOLET -> "보"
    }
}

// 코틀린스럽게 여러 값 사용 (Enum내 상수를 전체 임포트하면 static하게 사용 가능)
fun getWarmth(color: Color) = when (color) {
    // 여러 값인 경우 콤마로 구분
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "natural"
    BLUE, INDIGO, VIOLET -> "Cold"
}

// 코틀린은 when 파라미터로 객체가 가능
fun getMix(c1: Color, c2:Color) = when(setOf(c1,c2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw IllegalArgumentException("조합이 없습니다")
}

// 객체를 이용해 비교하는 경우 가독성은 높아지지만 함수가 자주 호출되는 경우 가비지 객체가 증가한다.
// getMix 리팩토링 -> 파라미터가 없는 when
fun refactorGetMix(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
    (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
    (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
    else -> throw IllegalArgumentException("조합이 없습니다.")
}