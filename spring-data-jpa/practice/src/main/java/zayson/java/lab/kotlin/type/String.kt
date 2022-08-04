package zayson.java.lab.kotlin.type

fun main() {
    val person = PersonJava("zayson", 28)
    println("name : ${person.name}") // 가동성이 좋음

    // 객체가 아닌 단순 변수의 경우 중괄호 생략 가능
    val name = "zayson"
    println("name : $name")

    // 멀티라인은 """.trimIndent() 사용 -> StringBuilder
    val multiline = """
        안녕하세요! 저는 ${person.name} 입니다.
        문자열을 아무거나 
        띄어쓰기 해도되고
        단락을 뛰어넘어도 나중에 trimIndent가 공백을 제거해준다.
        정말 좋다 !
    """.trimIndent()

    println(multiline)

    // charAt
    val alphabet = "abcde"
    print(alphabet[0]) // a
    print(alphabet[4]) // e

}