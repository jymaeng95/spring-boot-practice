package zayson.java.lab.kotlin.grammer.lecture19

class GeneralPerson (val firstName: String, val lastName: String) {
    // componentN 함수는 연산자의 속성을 가짐 (연산자 오버로딩처럼 동작)
    operator fun component1(): String = this.firstName

    operator fun component2(): String = this.lastName
}