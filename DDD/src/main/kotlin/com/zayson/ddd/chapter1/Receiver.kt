package com.zayson.ddd.chapter1

/**
 * ShippingInfo의 필드들을 VO로 변경
 */
data class Receiver(
    private val name: String,
    private val phoneNumber: String,
)
