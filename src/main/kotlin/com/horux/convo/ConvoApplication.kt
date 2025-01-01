package com.horux.convo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConvoApplication

fun main(args: Array<String>) {
    runApplication<ConvoApplication>(*args)
}
