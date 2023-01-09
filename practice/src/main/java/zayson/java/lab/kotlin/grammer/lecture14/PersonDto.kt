package zayson.java.lab.kotlin.grammer.lecture14

fun main() {
    val personDto = PersonDto(name = "zayson", age = 29)
    val personDto2 = PersonDto(name = "zayson", age = 29)
    val personDto3 = PersonDto(name = "maeng", age = 100)

    // equlas and hashcode
    println(personDto == personDto2)
    println(personDto3)
    println(personDto2.hashCode())
    println(personDto.hashCode())
}

data class PersonDto(
    private val name: String,
    private val age: Int
)