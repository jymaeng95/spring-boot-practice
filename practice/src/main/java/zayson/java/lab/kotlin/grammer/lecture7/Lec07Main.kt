package zayson.java.lab.kotlin.grammer.lecture7

import java.lang.NumberFormatException

fun parseIntOrThrow(str: String): Int {
    try {
        // 기본타입간 형변환 toType 메서드 사용
        return str.toInt()
    } catch (e: NumberFormatException) {
        // new 사용 안함, 타입이 뒤에 위치
        throw IllegalArgumentException(e.message)
    }
}

// null 값을 반환하는 예제
fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun main() {
    // IllegarArgumentException
    print(parseIntOrThrow("zayson"))
    print(parseIntOrThrowV2("zayson"))
}