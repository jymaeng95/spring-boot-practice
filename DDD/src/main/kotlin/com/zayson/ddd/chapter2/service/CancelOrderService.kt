package com.zayson.ddd.chapter2.service

import com.zayson.ddd.chapter2.domain.Order
import org.springframework.transaction.annotation.Transactional

open class CancelOrderService (
    private val order: Order
){
    @Transactional
    open fun cancelOrder(orderId: Long) {
        order.findOrderByID(orderId)?.cancel()  // 도메인 영역의 함수
            ?: throw IllegalArgumentException("Illegal Order Id")
    }
}