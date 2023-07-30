package com.zayson.ddd.chapter1

data class Money(
    val value: Int
) {
    // 금액 계산을 위한 추가 기능을 구현 가능
    fun add(money: Money) = Money(value + money.value)
    fun multiply(multiplier: Int) = Money(value * multiplier)
}
