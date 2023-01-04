package zayson.java.lab.kotlin.grammer.lecture10

abstract class Animal (
    // protected 접근 제어자
    protected val species: String,
    protected open val legCount: Int
){
    //추상 클래스
    abstract fun move()
}