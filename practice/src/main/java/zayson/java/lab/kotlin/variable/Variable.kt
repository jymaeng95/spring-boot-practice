package zayson.java.lab.kotlin

import zayson.java.lab.kotlin.variable.Person_Java

fun main() {
    var number1 = 10L   //Variable (가변 변수)
    number1 = 28L   // 값을 바꾸는 것이 가능

    val number2 = 10L   //Value (상수, 바꿀수 없음)

    var number3: Int = 10   // 변수명 : 타입(선택)

    var number4: Int
    println(number2)

    // val 컬렉션 안에 요소를 추가하는 것이 가능

    // TIP : 변수는 val로 사용하다가 필요한 경우 var로 바꾼다.

    // Primitive Type , Reference Type
    var number5 = 10L       // lona number5 = 10L
    var number6 = 10L       // Long number6 = 10L

    // 변수에 null을 넣고 싶은 경우 타입?를 사용한다.
    var number7: Long?
    number7 = null

    // 객체 인스턴스화
    var person = Person_Java("zayson")   // new를 사용하지 않음
}