package zayson.java.lab.kotlin.grammer.lecture13

class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    // 권장되는 중첩 클래스
    class LivingRoom (
        private val area: Double
    )

    // 내부 클래스 (바깥 참조 가능)
    inner class LivingRoomV2 (
        private val area : Double
    ) {
        val address: String
            // this@바깥 클래스 명으로 접근
            get() = this@House.address
    }
}