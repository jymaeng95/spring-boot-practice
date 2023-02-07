package zayson.java.lab.kotlin.basic
import java.util.Random

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
    // 커스텀 Getter 설정
    get() {
        return height == width
    }
}

// 랜덤 사각형 만들기
fun createRandomRectangle(): Rectangle {
    val random = Random()   // 자바 랜덤 임포트 가능
    return Rectangle(random.nextInt(), random.nextInt())
}