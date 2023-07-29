package com.zayson.ddd.chapter1

data class ShippingInfo (
    private val receiverName: String,
    private var receiverPhoneNumber: String,
    private var shippingAddress1: String,
    private var shippingAddress2: String,
    private var shippingAddress3: String,
){

}