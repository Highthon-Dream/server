package com.example.wegoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WegoServerApplication

fun main(args: Array<String>) {
    runApplication<WegoServerApplication>(*args)
}
