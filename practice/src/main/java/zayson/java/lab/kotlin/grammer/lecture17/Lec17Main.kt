package zayson.java.lab.kotlin.grammer.lecture17

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
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "apple"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "apple"}

    isApple(fruits[0])
    isApple2.invoke(fruits[1])
}

