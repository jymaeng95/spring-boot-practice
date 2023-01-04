package zayson.java.lab.kotlin.grammer.lecture10

class Penguin(
    species: String,
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()  // super<인터페이스>.메서드로 호출
        super<Flyable>.act()
    }

    override val swimAbility: Int
        get() = super.legCount + this.wingCount
}