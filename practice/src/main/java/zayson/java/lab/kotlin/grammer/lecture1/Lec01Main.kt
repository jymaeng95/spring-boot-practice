package zayson.java.lab.kotlin.grammer.lecture1

fun main() {
    // 코틀린 = 타입을 추론
    var number1: Long = 10L // variable : 가변변수
    val number2 = 10L // 불변 변수 = 자바의 final

    var  number3: Long = 5// 콜론을 통해 타입 선언 가능
    println(number3) // 초기화 필요

    val number4: Long
    number4 = 10L // val 변수의 경우 최초 1회 초기화에 한해 값 대입 가능
    println(number4)

    // 자바가 불변 컬렉션에 add를 통해 원소를 넣을 수 있는 것 처럼 코틀린도 val 객체에 데이터를 넣을 수 있음
    // 모든 변수는 val로 선언 -> 필요한 경우에만 var로 변경

    // 자바는 프리미티브 타입과 래퍼 타입에 대한 연산이 구분 (박싱, 언박싱) - 코틀린은 자동으로 박싱 언박싱 추론해서 계산
    var number5: Long = 10L // long number5 = 190L;
    var number6: Long = 10L // Long number6 = 10L;

    // 래퍼런스 타입은 Null을 가질 수 있음 (자바)
    // 코틀린은 기본적으로 null을 못들어가게 만듬, null이 들어가게 하기 위해 타입?를 사용
    val number7: Long? = null

    // 코틀린은 객체 인스턴스화 할때 new를 붙히지 않음
    var persob = Person("zayson")
}