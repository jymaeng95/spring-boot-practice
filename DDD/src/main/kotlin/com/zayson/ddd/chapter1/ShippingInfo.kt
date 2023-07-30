package com.zayson.ddd.chapter1

// ShippingInfo를 VO로 변경해주는 것이 가독성 측면에서 좋음
data class ShippingInfo (
    private val receiver: Receiver,
    private val address: Address,
)