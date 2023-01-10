package zayson.java.lab.kotlin.grammer.lecture16

fun main() {
    val name = "zayson"
    name.lastChar()
}

// String 클래스를 확장
fun String.lastChar(): Char {
    // 함수 내에서는 this를 이용해 실제 클래스 안의 값을 접근
    // this = 수신 객체, String = 수신 객체 타입
    return this[this.length - 1]
}