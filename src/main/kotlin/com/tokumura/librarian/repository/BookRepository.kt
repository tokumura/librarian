package com.tokumura.librarian.repository

import com.tokumura.librarian.domain.model.Book


interface BookRepository {
    fun findAll(): List<Book>
    fun findById(id: Int): Book
    fun findAllByAuthorId(authorId: Int): List<Book>
    fun create(book: Book): Book
    fun update(book: Book): Book
    fun delete(id: Int): Int
}