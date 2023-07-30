package com.zayson.ddd.chapter1

class OrderLine (
    private var product: String,  // 상품 (Product Class String으로 대체)
    private var price: Money,  // 상품 가격 (Money 타입으로 변경)
    private var quantity: Int,  // 구매 개수
){
    var amounts = calculateAmounts()  // 구매 가격 합 (Money 타입으로 변경)
    private fun calculateAmounts(): Money = price.multiply(quantity)
}