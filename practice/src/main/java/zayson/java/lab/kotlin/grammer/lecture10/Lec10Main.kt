package zayson.java.lab.kotlin.grammer.lecture10

fun main() {

}

open class Base(
    open val number: Int = 100
){
    init {
        println("Base")
        println(number)  // 하위 클래스에서 오버라이딩한 프로퍼티를 읽어야하지만, 하위 클래스는 인스턴스화 이전 상태
    }
}

class Derived(
    // 프로퍼티 오버라이드
    override val number: Int
) : Base(number) {
    init {
        println("Derived")
    }
}