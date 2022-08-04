package zayson.java.lab.kotlin.basic

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {

}

fun eval(e: Expr): Int {
    if(e is Num) {
        val n = e as Num
        return e.value
    }
    if(e is Sum) {
        val left = e.left as Num
        val right = e.right as Num

        return left.value + right.value
    }

    throw IllegalArgumentException("예외 발생")
}