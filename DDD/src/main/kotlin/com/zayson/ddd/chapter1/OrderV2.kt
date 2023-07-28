package com.zayson.ddd.chapter1

import com.zayson.ddd.chapter1.OrderStateV2.*

// 실제 배송지 변경 로직과 배송지 변경 여부 로직이 함께 있음
class OrderV2 {
    private var orderState = PREPARING
    private var shippingInfo: String? = null

    // 실제 배송지 변경 로직
    fun changeShippingInfo(newShippingInfo: String) {
        if (isShippingChangeable(orderState)) {
            throw IllegalStateException("can't change shipping in $orderState")
        }

        this.shippingInfo = newShippingInfo
    }

    // 배송지 변경 여부
    private fun isShippingChangeable(orderState: OrderStateV2): Boolean = when (orderState) {
        PAYMENT_WAITING, PREPARING -> true
        else -> false
    }
}

// 주문 배송 상태만 표시
enum class OrderStateV2 {
    PAYMENT_WAITING, PREPARING, SHIPPED,DELIVERING, DELIVERY_COMPLETED
}