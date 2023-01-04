package zayson.java.lab.kotlin.grammer.lecture11

// 파일 최상단에 유틸함수 작성 -> 자바 디컴파일 시 static 메서드로 생성됨
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}