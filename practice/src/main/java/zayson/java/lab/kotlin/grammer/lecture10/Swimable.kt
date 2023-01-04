package zayson.java.lab.kotlin.grammer.lecture10

interface Swimable {
    // 백킹 필드 없는 프로퍼티 (오버라이딩 필요) - getter로도 사용 가능하므로
    val swimAbility: Int
        get() = 4  // 디폴트 게터 지정 가능

    fun act() {
        // 인터페이스 구현체에서 구현했을 거라 가정하고 사용 가능
        println(swimAbility)
        println("어푸 어푸")
    }
}