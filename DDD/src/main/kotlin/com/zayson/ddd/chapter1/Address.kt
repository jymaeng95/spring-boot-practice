package com.zayson.ddd.chapter1

/**
 * ShippingInfo의 필드들을 VO로 변경
 */
data class Address(
    private val address1: String,
    private val address2: String,
    private val zipcode: String,
)
