package com.tokumura.librarian.application.service

import com.tokumura.librarian.domain.model.Book
import com.tokumura.librarian.domain.model.BookWithAuthor
import com.tokumura.librarian.presentation.form.book.BookCreateForm
import com.tokumura.librarian.presentation.form.book.BookUpdateForm
import com.tokumura.librarian.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepo: BookRepository
) {
    @Transactional(readOnly = true)
    fun getBooks() : List<Book> = bookRepo.findAll()

    @Transactional(readOnly = true)
    fun getBooksByAuthor(authorId: Int) : List<Book> = bookRepo.findAllByAuthorId(authorId)

    @Transactional(readOnly = true)
    fun searchBooksByAuthorName(authorName: String) : List<BookWithAuthor> = bookRepo.findAllByAuthorName(authorName)

    @Transactional(readOnly = true)
    fun getBook(id: Int) : Book = bookRepo.findById(id)

    @Transactional
    fun createBook(form: BookCreateForm) : Book {
        val book = Book(form.title, form.authorId)
        return bookRepo.create(book)
    }

    @Transactional
    fun updateBook(id: Int, form: BookUpdateForm) : Book {
        val book = Book(id, form.title, form.authorId)
        return bookRepo.update(book)
    }

    @Transactional
    fun deleteBook(id: Int) = bookRepo.delete(id)
}