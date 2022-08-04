package zayson.java.lab.kotlin.basic

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);  // enum 상수 목록과 메서드 사이에는 세미콜론을 사용한다.

    // 메서드 정의
    fun rgb() = (r * 256 + g) * 256 + b
}