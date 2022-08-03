package zayson.java.lab.kotlin.variable

fun main(args: Array<String>) {
    var name = "zayson"

    // {$변수명} = $변수명
    print("name is $name")
    print("name is ${name}")

    // 문[자열 템플릿 사용 시 중괄호로 감싸는 것이 유지보수 측면에서 좋다.(가독성도 증가)
//    print("안녕하세요 저는 $name입니다")
    print("안녕하세요 저는 ${name}입니다")

    // 템플릿 안에 식이 들어가는 것이 가능
    print("안녕하세요 저는 ${if (name.length > 5) "length" else name}")
}