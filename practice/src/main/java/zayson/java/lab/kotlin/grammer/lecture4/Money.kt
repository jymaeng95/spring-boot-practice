package zayson.java.lab.kotlin.grammer.lecture4

data class Money(val amount: Long) {
    operator fun plus(other: Money) = Money(this.amount + other.amount)

    // 잘못된 이름의 연산자를 오버로딩 하는 경우 컴파일 에러 발생
//    operator fun aplus(other: Money) = Money(this.amount + other.amount)
}
