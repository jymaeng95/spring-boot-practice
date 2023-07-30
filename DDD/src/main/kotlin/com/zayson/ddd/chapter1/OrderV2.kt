package com.zayson.ddd.chapter1

import com.zayson.ddd.chapter1.OrderStateV2.*
import java.lang.IllegalArgumentException

// 실제 배송지 변경 로직과 배송지 변경 여부 로직이 함께 있음
data class OrderV2 (
    val orderNumber: OrderNo,  // 엔티티를 구분할 수 있는 식별자
    var orderLines: MutableList<OrderLine>,
    var shippingInfo: ShippingInfo
){
    private var orderState: OrderStateV2 = PREPARING
    private var totalAmounts: Int = 0  // 구매 상품 합계

    // init을 통해 Order 생성 후 초기화
    init {
        setOrderLines(orderLines)  // 주문라인 추가
        setShippingInfo(shippingInfo)
        calculateTotalAmounts()  // 주문 총합 구하기
    }

    // 요구사항) 최소 한 종류 이상의 상품을 주문해야 한다 == orderLines의 size는 1이상
    private fun setOrderLines(orderLines: MutableList<OrderLine>) {
        verifyAtLeastOneOrMoreOrderLines(orderLines)  // 최소 한 종류 이상 담겼는지 검증
        this.orderLines = orderLines
    }

    // 최소 한 종류 이상 담겼는지 검증
    private fun verifyAtLeastOneOrMoreOrderLines(orderLines: MutableList<OrderLine>) {
        if (orderLines.isEmpty()) {
            throw IllegalArgumentException("No OrderLines")
        }
    }

    //주문 총합 구하기
    private fun calculateTotalAmounts() {
        totalAmounts = orderLines.map(OrderLine::amounts).sumOf { money -> money.value }
    }

    // 배송지 지정하기 (Nullable하지 않은 타입을 지정하므로 예외 처리 필요X)
    private fun setShippingInfo(shippingInfo: ShippingInfo) {
        this.shippingInfo = shippingInfo
    }

    // 주문을 취소한다
    fun cancel()  {
        verifyNotYetShipped()
        this.orderState = CANCELED
    }
    fun completePayment() = {}

    // 실제 배송지 변경 로직
    fun changeShippingInfo(newShippingInfo: ShippingInfo) {
        // 출고 되기 전인 경우에만 배송지 변경 가능
        if (verifyNotYetShipped()) {
            throw IllegalStateException("can't change shipping in $orderState")
        }

        this.shippingInfo = newShippingInfo
    }

    // 출고 여부
    private fun verifyNotYetShipped(): Boolean = when (orderState) {
        PAYMENT_WAITING, PREPARING -> true
        else -> throw IllegalStateException("already shipped.")
    }

}

// 주문 배송 상태만 표시
enum class OrderStateV2 {
    PAYMENT_WAITING, PREPARING, SHIPPED,DELIVERING, DELIVERY_COMPLETED, CANCELED;
}