package zayson.java.lab.kotlin.grammer.lecture14

enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US"),
    EUROPE("EU")
}

fun handleCountry(country: Country) {
    // when 반환식으로 사용하는 경우 enum에 누락된 코드가 있다면 에러 발생
    when (country) {
        Country.KOREA -> println("KO")
        Country.AMERICA -> println("US")

        else -> println("else")
    }
}
