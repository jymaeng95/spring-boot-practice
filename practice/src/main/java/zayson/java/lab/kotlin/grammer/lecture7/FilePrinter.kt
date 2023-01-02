package zayson.java.lab.kotlin.grammer.lecture7

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {
    //
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))

        // Java의 경우 IOException이 CheckedException 컴파일 에러
        // 코틀린의 경우 모두 UncheckedException으로 판단 -> 컴파일 에러 발생안함
        print(reader.readLine())
        reader.close()
    }

    fun readFileV2(path: String) {
        // 코틀린은 try-with-resources 구문이 없음
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}