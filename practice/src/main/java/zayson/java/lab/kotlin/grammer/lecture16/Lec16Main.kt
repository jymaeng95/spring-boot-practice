package zayson.java.lab.kotlin.grammer.lecture16

fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

fun main() {
    val person = Person("zayson", "maeng", 29)
    println(person.nextYearAge())
}