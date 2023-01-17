package zayson.java.lab.kotlin.grammer.lecture17

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val fruits = listOf(
        Fruit("apple", 1000),
        Fruit("apple", 1200),
        Fruit("apple", 1500),
        Fruit("apple", 1200),
        Fruit("banana", 3000),
        Fruit("banana", 3200),
        Fruit("banana", 4000),
        Fruit("watermelon", 10000)
    )

    // 함수를 변수에 넣는 경우 함수명이 없고 fun 뒤에 파라미터와 리턴타입이 들어감
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "apple"
    }

    // 중괄호를 만들어서 함수를 처리
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "apple" }

    isApple(fruits[0])
    isApple2.invoke(fruits[1])

    // 타입에 맞는 함수를 파라미터로 넘겨도 됨
    filterFruits(fruits, isApple)
    // fruit -> it으로 변경해줄 수 있음, 파라미터로 넘기는 함수가 마지막에 존재하는 경우 괄호 밖에 함수 명세 가능
    filterFruits(fruits, { fruit: Fruit -> fruit.name == "apple" })

    // 파라미터가 한개인 경우 it으로 표현 가능 (arrow 삭제 가능)
    filterFruits(fruits) { it.name == "apple"}



}
// FruitFilter만들기
private fun filterFruits(fruits: List<Fruit>, fruitFilter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if(fruitFilter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}

private fun readFileV2(path: String): Int {
    // 코틀린은 try-with-resources 구문이 없음
    return BufferedReader(FileReader(path)).use { reader ->
        println(reader.toString())
        reader.hashCode()
    }
}
