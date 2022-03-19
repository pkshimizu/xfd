package net.noncore.xfd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class XfdApplication

fun main(args: Array<String>) {
	runApplication<XfdApplication>(*args)
}
