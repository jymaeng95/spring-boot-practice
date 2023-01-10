package zayson.java.lab.kotlin.grammer.lecture16

open class Train(
    val name: String = "새마을호",
    val price: Int = 5000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장 함수")
    return this.price >= 10000
}

class SRT : Train("SRT", 50000)

fun SRT.isExpensive(): Boolean {
    println("SRT의 확장함수")
    return this.price >= 10000
}

fun main() {
    val train: Train = Train()
    train.isExpensive()

    val srt: Train = SRT()  // SRT를 인스턴스화 했지만 실제 호출되는 함수는 Train
    srt.isExpensive()

    val srt2: SRT = SRT()
    srt2.isExpensive()
}