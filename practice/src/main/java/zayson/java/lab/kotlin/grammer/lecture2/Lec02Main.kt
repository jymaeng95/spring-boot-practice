package zayson.java.lab.kotlin.grammer.lecture2

fun main() {
    // safe call test
    val str: String? = null
    println(str?.length ?: "zayson")

    val person = Person("zayson")
    startsWith(person.name)
}

fun startsWith(str: String): Boolean {
    return str.startsWith("A")
}

// 첫번째 함수 (String은 Null이 들어올 수 있으므로 ? 사용)
fun startsWithV1(str: String?): Boolean { // Boolean 타입에 반드시 null이 안들어감
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어옵니다")
}

// 두번째 함수 null을 리턴할 수도 있으므로 null 허용
fun startsWithV2(str: String?): Boolean? {
    return str?.startsWith("A")
}

// 세번째 함수
fun startsWithV3(str: String?): Boolean {
    // 바로 str.startsWith하면 컴파일 에러 발생(String? 타입이기 때문에  null이 가능하므로)
//    str.startsWith("A")

    return str?.startsWith("A") ?: false
}

// null 아님 단언
fun startsWithV4(str: String?): Boolean {
    return str!!.startsWith("A")
}