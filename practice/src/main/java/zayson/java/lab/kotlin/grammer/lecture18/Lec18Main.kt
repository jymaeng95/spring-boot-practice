package zayson.java.lab.kotlin.grammer.lecture18


fun main() {
    val fruits = listOf(
        Fruit(1L, "apple", 1000, 2000),
        Fruit(2L, "apple", 1200, 1200),
        Fruit(3L, "apple", 1500, 1500),
        Fruit(4L, "apple", 1200, 2000),
        Fruit(5L, "banana", 3000, 3000),
        Fruit(6L, "banana", 3200, 4000),
        Fruit(7L, "banana", 4000, 5000),
        Fruit(8L, "watermelon", 10000, 11000)
    )

    // filter (이름이 apple인 fruit만 추출)
    val data = fruits.filter { fruit -> fruit.name == "apple" }
    println("apple list : ${data}")

    // filterIndexed
    val fruitList = fruits.filterIndexed { index, fruit ->
        println("${index} 번째 출고가 : ${fruit.factoryPrice}")
        fruit.factoryPrice > 3000
    }
    println(fruitList.size)

    // map (fruit의 이름만 추출)
    val nameList = fruits.map { fruit -> fruit.name }
    println(nameList.toString())

    // mapIndexed
    val factoryPrices = fruits.mapIndexed { index, fruit ->
        println("${index} 번째 이름 : ${fruit.name}")
        fruit.factoryPrice
    }
    println(fruits.toString())

    // mapNotNull (null이 아닌 것만 맵핑)
    val list = listOf(null, null, "test", "test1", "test3")
    val notNullData = list.mapNotNull { element -> element?.toString() }
    println(notNullData.toString())

    // all (모든 factoryPrice가 1000원 이상인 경우 true)
    val allResult = fruits.all { fruit -> fruit.factoryPrice >= 1000 }
    println(allResult) // true

    // any (하나라도 과일의 이름이 watermelon인 경우 true)
    val anyResult = fruits.any { fruit -> fruit.name == "watermelon" }
    println(anyResult)

    // none (모두 불만족해야 true)
    val noneResult = fruits.none { fruit -> fruit.factoryPrice < 1000 }
    println(noneResult)

    // count (이름이 apple인 fruit의 개수 세기)
    val count = fruits.count { fruit -> fruit.name == "apple" }
    println(count)

    // sortedBy (판매금액이 싼 순으로 정렬)
    fruits.sortedBy { fruit -> fruit.currentPrice }
        .forEach { fruit -> println("${fruit.name} : ${fruit.currentPrice}") }

    // sortedByDescending (판매금액이 비싼순으로 정렬)
    fruits.sortedByDescending { fruit -> fruit.currentPrice }
        .forEach { fruit -> println("${fruit.name} : ${fruit.currentPrice}") }

    // distinctBy (이름을 추출해 중복을 제거한다.)
    val names = fruits.distinctBy { fruit -> fruit.name }.map { fruit -> fruit.name }
    println(names.toString())

    // first, firstOrNull
    val firstApple = fruits.sortedBy { fruit -> fruit.currentPrice }.first { fruit -> fruit.name == "apple" }
    println(firstApple.toString())

    val maybeNull =
        fruits.sortedBy { fruit -> fruit.currentPrice }.firstOrNull { fruit -> fruit.name == "strawberry" }
    println(maybeNull)

    // last, lastOrNull
    val lastFruit = fruits.sortedBy { fruit -> fruit.currentPrice }.last()
    println(lastFruit.toString())

    val lastApple = fruits.sortedBy { fruit -> fruit.currentPrice }.lastOrNull { fruit -> fruit.name == "apple" }
    println(lastApple.toString())

    // groupBy (List -> Map, 과일의 이름을 키로 맵을 생성)
    val fruitMap: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    println("type : ${fruitMap::class}, ${fruitMap.toString()}")

    // groupBy (List -> Map, 과일의 이름을 키로 가격들의 리스트를 구함)
    val priceMap = fruits.groupBy({ fruit -> fruit.name }, {fruit -> fruit.currentPrice})
    priceMap.forEach{ (key, value) ->
        println("key : ${key} priceList : ${value.toString()}")
    }

    // associateBy (List -> Map, 중복되지 않는 키를 이용해 맵을 생성 value가 값 그자체)
    val map= fruits.associateBy { fruit -> fruit.id }
    println(map.toString())

    val fruitsInList = listOf(
        listOf(
            Fruit(1L, "apple", 1000, 2000),
            Fruit(2L, "apple", 1200, 1200),
            Fruit(3L, "apple", 1500, 1500),
            Fruit(4L, "apple", 1200, 2000)
        ),
        listOf(
            Fruit(5L, "banana", 3000, 3000),
            Fruit(6L, "banana", 3200, 4000),
            Fruit(7L, "banana", 4000, 5000),
        ),
        listOf(
            Fruit(8L, "watermelon", 10000, 11000)
        )
    )

    println("============================")
    // flatMap (중첩 리스트를 평탄화)
    val flatMap = fruitsInList.flatMap { list -> list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice } }
    println(flatMap)

    // 일반 리스트로 평탄화
    fruitsInList.flatten()

}

private fun filterFruits(fruits: List<Fruit>, fruitFilter: (Fruit) -> Boolean): List<Fruit> = fruits.filter(fruitFilter)