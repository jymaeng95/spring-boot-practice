package zayson.java.lab.kotlin.grammer.lecture5

// 리턴 타입에 Unit(void)이 생략
fun validateScore(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}가 0보다 작을 수 없다")
    }
}

fun validateScoreV2(score: Int): String {
    if (score !in 0..100) {
        throw IllegalArgumentException("0에서 100점 사이여야 합니다")
    }

    // 50점이상 70점 이하인 경우
    if (score in 50..70) {
        return "A"
    }

    return "B"
}

/*
 * Kotlin if-else문은 Expression
 * return if문 가능
 */
fun getGrade(score: Int): String {
    return if (score <= 50) {
        "P"
    } else "F"
}

fun getGradeV2(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score <= 80) {
        "B"
    } else "C"
}

fun main() {
    val score = 100
    val grade = if (score <= 50) {
        "P"
    } else "F"
}

// 기본적인 when
fun getGradeWithWhen(score: Int): String {
    // 값을 보고 비교
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

// 범위 조건을 통한 분기
fun getGradeWithScoreV2(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 ->"C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean{
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when(number) {
        1, 0, -1 -> println("간단한 숫자")
        else -> println("나머지 숫자")
    }
}

fun judgeNumberV2(number: Int) {
    // 값이 없는 경우 조건식을 보고 해당 구문 실행
    when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어진 숫자는 홀수입니다")
    }
}