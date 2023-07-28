package com.zayson.ddd.chapter1

class OrderV1 {
    private var orderState: OrderStateV1 = OrderStateV1.PAYMENT_WAITING
    private var shippingInfo: String? = null  // ShippingInfo 타입 대신 String 값 사용

    // 주문 상태 변경
    fun changeShippingInfo(newShippingInfo: String) {
        if (!orderState.isShippingChangeable()) {
            throw IllegalStateException("can't change shipping in $orderState")
        }

        this.shippingInfo = newShippingInfo
    }
}

enum class OrderStateV1 {
    /**
     * 주문 대기 중이거나 상품 준비 중인 경우 배송지 변경 가능
     * 이외의 경우 배송지 변경 불가
     */
    PAYMENT_WAITING {
        override fun isShippingChangeable() = true
    },
    PREPARING {
        override fun isShippingChangeable() = true
    },
    SHIPPED, DELIVERING, DELIVERY_COMPLETED;

    open fun isShippingChangeable() = false
}