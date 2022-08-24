package zayson.java.lab.kotlin.basic

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val rst = eval(Sum(Num(1), Num(2)))
    println("rst = ${rst}")

    val rst2 = evalIf(Sum(Num(1), Num(2)))
    println("rst2 = ${rst2}")


}

fun eval(e: Expr): Int {
    // e가 Num 인스턴스인 경우
    if(e is Num) {

        val n = e as Num  // 스마트 캐스트로 생략 가능
        return n.value
    }

    // e가 Sum 인스턴스인 경우
    if(e is Sum)
        return eval(e.left) + eval(e.right)


    throw IllegalArgumentException("예외 발생")
}

// 식을 본문으로 사용하기
fun evalIf(e: Expr): Int =
    if (e is Num) e.value
    else if (e is Sum) evalIf(e.left) + evalIf(e.right)
    else throw IllegalArgumentException("예외 발생")

// when 절로 사용하기