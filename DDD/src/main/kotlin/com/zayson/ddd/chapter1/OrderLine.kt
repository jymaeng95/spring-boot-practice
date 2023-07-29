package com.zayson.ddd.chapter1

class OrderLine (
    private var product: String,  // 상품 (Product Class String으로 대체)
    private var price: Int,  // 상품 가격
    private var quantity: Int,  // 구매 개수
){
    var amounts = calculateAmounts()  // 구매 가격 합
    private fun calculateAmounts(): Int = price * quantity
}