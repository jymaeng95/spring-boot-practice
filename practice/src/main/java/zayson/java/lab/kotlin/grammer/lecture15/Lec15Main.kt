package zayson.java.lab.kotlin.grammer.lecture15


fun main() {
    val array = arrayOf(100, 200)
    // 배열에 원소 추가 (plus 메서드)
    array.plus(300)

    // 인덱스를 이용한 for문
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    // 인덱스, 값을 통한 순회
    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    // ========= List ========= //

    // 리스트 선언
    val numbers = listOf(100, 200)  // 타입 추론 가능하므로 타입 지정 불필요
    val emptyList = emptyList<Int>()   // 빈 컬렉션의 경우 타입 지정 필요

    // 리스트 원소 하나 접근
    println(numbers[0])

    // for each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 for 문
    for ((idx, value) in numbers.withIndex()) {
        println("${idx}. ${value}")
    }

    // 가변 리스트 선언
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)

    println(mutableNumbers.size)

    // ====== Set ======= //
    val set = setOf(100, 200)   // 불변 Set
    val mutableSetOf = mutableSetOf(100, 200)  // 가변 Set
    val emptySet = emptySet<Int>() // emptySet

    // ===== Map ===== //
    var oldMap = mutableMapOf<Int, String>()    // 타입 추론 불가한 경우 타입 지정
    oldMap.put(1, "zayson") // 기존 자바와 동일한 방식
    oldMap[2] = "maeng" // 배열 인덱스 접근 처럼 맵 넣는 것 가능

    val mutableMap = mutableMapOf(1 to "zayson", 2 to "maeng")  // 중위함수를 이용한 맵 생성 (타입 추론 가능)
    val map = mapOf(1 to "zayson", 2 to "maeng")

    // ===== Map.Entry ===== //
    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    // entry를 통해 바로 접근
    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

    // value 기준 정렬
    oldMap = oldMap.toList().sortedBy { it -> it.second }.toMap() as MutableMap
    for (key in oldMap.keys) {
        println("${key} , ${oldMap[key]}")
    }
}

// 파라미터에 타입이 지정된 경우 타입 추론 가능
private fun printNumbers(numbers: List<Int>) = println(numbers.size)