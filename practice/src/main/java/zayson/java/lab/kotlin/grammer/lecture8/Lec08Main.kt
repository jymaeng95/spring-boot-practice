package zayson.java.lab.kotlin.grammer.lecture8

fun main() {
    repeat("call ", 5, true)
    repeat("call1 ", useNewLine = false)
    repeat("call2 ", 2)

    printAll("A", "B", "C")

    val arr = arrayOf("A", "B", "C")
    printAll(*arr)
}

// 조건절 = Expression, 값 대입 가능
fun max(a: Int, b: Int) = if (a > b) a else b

// default Parameter를 이용해
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if(useNewLine) println(str)
        else print(str)
    }
}

// 기변인자
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}