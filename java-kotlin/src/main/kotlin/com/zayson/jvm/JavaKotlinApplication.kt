package com.zayson.jvm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaKotlinApplication

fun main(args: Array<String>) {
    runApplication<JavaKotlinApplication>(*args)
}
