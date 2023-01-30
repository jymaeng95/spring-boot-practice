package zayson.java.lab.kotlin.grammer.lecture19

fun main() {
    val person = Person("zayson", 29)
    val (name, age) = person // 구조 분해 문법
    val name1 = person.component1()
    val age1 = person.component2()

    println("name = ${name}, age = ${age}")

    // 일반 클래스의 componentN
    val (firstName, lastName) = GeneralPerson("zayson", "maeng")

    // jump, label
    val ages = listOf(1, 10, 5, 100, 2, 29, 30, 56, 25, 26)
    ages.map { age -> age + 1 }
        .forEach { age -> println(age) }

    run {
        ages.forEach { age ->
            age + 1
            if (age > 20) return@run // run block을 return 함으로써 break문의 효과를 줌
            println(age)
        }
    }

    ages.forEach { age ->
        age + 1
        if(age > 20) return@forEach // return forEach함으로써 continue의 효과를 줌
        println("age is ${age}")
    }

    // label
    firstLoop@ for (number in 1..100) {
        for (value in 1..100) {
            if( value == 2) break@firstLoop
            println("${number}, ${value}")
        }
    }

    fun getOrNull(name: String): String? = name.takeIf{ it.length < 3}
    println(getOrNull("zayson"))
    println(getOrNull("ab"))
}

