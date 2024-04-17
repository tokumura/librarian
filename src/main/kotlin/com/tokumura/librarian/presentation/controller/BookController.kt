package com.tokumura.librarian.presentation.controller

import com.tokumura.librarian.application.service.BookService
import com.tokumura.librarian.presentation.form.book.BookCreateForm
import com.tokumura.librarian.presentation.form.book.BookUpdateForm
import com.tokumura.librarian.presentation.form.book.BookResponse
import com.tokumura.librarian.presentation.form.book.BookSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/books")
    fun getBooks(): List<BookResponse> {
        val books = bookService.getBooks()
        return books.map { BookResponse(it) }
    }

    @GetMapping("/books_by_author/{authorId}")
    fun getBooksByAuthor(
        @PathVariable("authorId") authorId: Int
    ): List<BookResponse> {
        val books = bookService.getBooksByAuthor(authorId)
        return books.map { BookResponse(it) }
    }

    @GetMapping("/books/search")
    fun getBooksSearch(
        @RequestParam("authorname") authorName: String
    ): List<BookSearchResponse> {
        val books = bookService.searchBooksByAuthorName(authorName)
        return books.map { BookSearchResponse(it) }
    }

    @GetMapping("/book/{id}")
    fun getBook(
        @PathVariable("id") id: Int
    ): BookResponse {
        val book = bookService.getBook(id)
        return BookResponse(book)
    }

    @PostMapping("/book")
    fun createBook(
        @RequestBody form: BookCreateForm
    ): BookResponse
    {
        val bookCreated = bookService.createBook(form)
        return BookResponse(bookCreated)
    }

    @PutMapping("/book/{id}")
    fun updateBook(
        @PathVariable("id") id: Int,
        @RequestBody form: BookUpdateForm
    ): BookResponse {
        val bookUpdated = bookService.updateBook(id, form)
        return BookResponse(bookUpdated)
    }

    @DeleteMapping("/book/{id}")
    fun deleteBook(
        @PathVariable("id") id: Int): Int
    {
        return bookService.deleteBook(id)
    }
}