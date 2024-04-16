package com.tokumura.librarian

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibrarianApplication

fun main(args: Array<String>) {
    runApplication<LibrarianApplication>(*args)
}
