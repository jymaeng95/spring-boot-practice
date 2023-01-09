package zayson.java.lab.kotlin.grammer.lecture12


class Person private constructor(
    var name: String,
    var age: Int
) {
    // 코틀린은 static 키워드가 없음 -> companion object 사용
    companion object Factory : Log { // companion object의 이름 = Factory, Log인터페이스 상속
        private const val MIN_AGE = 1

        @JvmStatic // 자바 코드에서 코틀린 파일의 메서드를 Static 함수처럼 사용 가능
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("logging factory")
        }
    }
}

// 싱글톤 클래스
object Singleton {
    var a: Int = 0
}

fun main() {
    // 익명 클래스 사용 방법 -> object : 인터페이스명
    moveSomething(object : Movable {
        override fun fly() {
            println("날다")
        }

        override fun move() {
            println("움직이다")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}