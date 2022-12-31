package zayson.java.lab.kotlin.grammer.lecture4

fun main() {
    val money1 = JavaMoney(2000L)
    val money2 = money1
    val money3 = JavaMoney(1000L)

    // Kotlin에서는 객체 비교 시 compareTo를 구현하고 호출하지 않아도 자동으로 비교한다.
    if (money1 > money2) {
        print("money1이 money2보다 크다")
    }

    println(money1 == money2)
    println(money1 === money2)
}