package com.horux.convo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.horux.convo.**"])
class ConvoApplication

fun main(args: Array<String>) {
    runApplication<ConvoApplication>(*args)
}
