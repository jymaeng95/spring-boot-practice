package zayson.java.lab.kotlin.type

fun main() {
    val number = 10  // int 타입으로 추론
    val nuamber2: Long = number.toLong() // Long 타입으로 캐스팅 안됨

    val number3 = 10
    val number4 = 3

    val result = number3 / number4
    print(result)

    val result2 = number3 / number4.toDouble()      // 나누기도 동일하게 타입 변환 메서드 사용
    print(result2)

    // Nullable인 경우
    val number5: Int? = 10
    val number6 = number5?.toLong() ?: 0L       // 엘비스 연산자와 Safe Call을 이용해 타입 변환 메서드 실행
}