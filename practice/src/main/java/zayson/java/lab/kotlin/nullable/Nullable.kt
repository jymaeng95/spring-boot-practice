package zayson.java.lab.kotlin.nullable

fun main() {
    val str: String? = null
    val str1: String = "Ab"
    println(str ?: false)


//    println(str.length)
    println(str?.length) // null이 아닌경우 실행 null이면 null
    println(str?.length ?: 0)

    println(checkNullFourthKotlin("!23"))


    val person = Person(null)
    // Nullable 메서드 때문에 에러가 날수 잇음
    // Java 코드를 가져와 사용하는 경우 코틀린이 자바 코드를 이해 -> null값 이므로 못쓰게함
    println(checkJavaClassNull(person.name))
}

// null이 안들어가기 때문
fun checkNullFirst(str: String?): Boolean {
    if (str == null)
        throw IllegalArgumentException("null")
    return str.startsWith("A")
}

// -> 코틀린 스럽게 바꾸기
fun checkNullFirstKotlin(str: String?): Boolean {
    return str?.startsWith("A")  // null이 아닌 경우 리턴
        ?: throw IllegalArgumentException("null") // null인 경우 예외 던지기
}

fun checkNullSecond(str: String?): Boolean? {
    if (str == null)
        return null
    return str.startsWith("A")
}

//-> 코틀린 스럽게
fun checkNullSecondKotlin(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun checkNullThird(str: String?): Boolean {
    // null일 수 있는 변수 타입에서 즉각적인 메서드콜 불가
    if (str == null)
        return false;

    // 널이 체크되었다면 코틀린이 알아서 캐스팅
    return str.startsWith("A")
}

// -> 코틀린 스럽게
fun checkNullThridKotlin(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun checkNullFourthKotlin(str: String?): Boolean {
    return str!!.startsWith("A")    // !! null아님 단언
    // null이 들어오는 경우 NPE
}

// 파라미터가 널이아니어야함
fun checkJavaClassNull(str: String): Boolean {
    return str.startsWith("A")
}