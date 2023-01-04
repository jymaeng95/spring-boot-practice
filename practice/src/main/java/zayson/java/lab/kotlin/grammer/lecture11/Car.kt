package zayson.java.lab.kotlin.grammer.lecture11

class Car private constructor(
    internal val name: String,  // name의 getter를 internal로 선언
    private var owner: String,  // owner의 getter/setter를 private으로 선언
    _price: Int
) {
    var price = _price
        private set  // getter의 경우 public, setter의 경우 private으로 지정

}