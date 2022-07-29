package zayson.java.lab.kotlin.type

fun main() {
//    printAgePersonNull(PersonJava("", 100))
    printAgePersonNull(null)
}

fun printAgeIfPerson(obj: Any) {
    if(obj is PersonJava) {
        val person = obj as PersonJava
        print(person.age)
    }
}

fun printAgeIfNotPerson(obj: Any) {
    if(obj !is PersonJava) {
        print(obj)
    }
}

fun printAgePersonNull(obj: Any?) {
    // obj가 null이 아니라면 Person으로 변환 null이면 전체가 null
    val person = obj as? PersonJava
    print(person?.age)
}

