package zayson.java.lab.kotlin.grammer.lecture9

// 기본 접근제한자 public
// 생성자가 위에 위치함 (constructor 생략 가능)
class Person constructor(val name: String, var age: Int) {
    // 초기화 검증 로직 (init)
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없다")
        }
    }

    // backing field를 이용한 커스텀 세터
//    var name: String = name
//        // 생성자를 통해 외부에서 들어오는 값
//        set(value) {
//            field = value.toUpperCase() // 들어온 값에 대해 백킹 필드를 이용해 대입
//        }

    // backing field
//    val name: String = name
//        get() = field.toUpperCase()

    // 추가 생성자
    constructor(name: String) : this(name, 1)

    // 커스텀 getter/setter
    // 함수로 사용하는 방법
    fun isAdultV1(): Boolean {
        return this.age >= 20
    }

    // 프로퍼티로 사용하는 방법
    val isAdultV2: Boolean
        get() = this.age >= 20

    val isAdultV3: Boolean
        get() {
            println("나이는 ${age}입니다")
            return this.age >= 20
        }

}

fun main() {
    val person = Person("zayson", 29)
    println(person.name)

    person.age = 10
    println(person.age)
}