package zayson.java.lab.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main() {
    GlobalScope.launch { // launch (코루틴빌더) (새로운 스레드가 생성?)
        delay(1000L)
        println("World")
    }
    println("Hello")
    Thread.sleep(2000L) // Function이 2초간 sleep 사이에 1초동안 Sleep하던 코루틴이 동작
}

fun userThread() {
    thread {
        Thread.sleep(1000L)
        println("World")
    }

    println("Hello")
    Thread.sleep(2000L)
}