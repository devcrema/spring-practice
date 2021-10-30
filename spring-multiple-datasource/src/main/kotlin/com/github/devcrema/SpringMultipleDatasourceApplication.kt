package com.github.devcrema

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMultipleDatasourceApplication

fun main(args: Array<String>) {
	runApplication<SpringMultipleDatasourceApplication>(*args)

}
