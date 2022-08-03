package zayson.java.lab.kotlin.variable

// Hello World
fun main(args: Array<String>) {
    println("Hello, world!")
    println(max(2, 3))
}

//함수 작성
fun max(a: Int, b: Int): Int {
    // 코틀린의 if는 식이다.
    return if (a > b) a else b
}

fun max2(a: Int, b: Int) = if (a > b) a else b