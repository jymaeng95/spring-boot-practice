package com.zayson.ddd.chapter2.domain

class Order (
    var name: String,
    val price: Int,
){

    // 실제 도메인 영역의 도메인 로직
    fun findOrderByID(orderId: Long): Order? {
        return Order("product", 1000)
    }

    fun cancel() {
        println("Delete Order")

    }
}