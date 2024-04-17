package com.tokumura.librarian.repository

import com.tokumura.librarian.domain.model.Book
import com.tokumura.librarian.domain.model.BookWithAuthor


interface BookRepository {
    fun findAll(): List<Book>
    fun findById(id: Int): Book
    fun findAllByAuthorId(authorId: Int): List<Book>
    fun findAllByAuthorName(authorName: String): List<BookWithAuthor>
    fun create(book: Book): Book
    fun update(book: Book): Book
    fun delete(id: Int): Int
}