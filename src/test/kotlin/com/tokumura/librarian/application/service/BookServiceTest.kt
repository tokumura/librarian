package com.tokumura.librarian.application.service

import com.tokumura.librarian.domain.model.Book
import com.tokumura.librarian.presentation.form.book.BookCreateForm
import com.tokumura.librarian.presentation.form.book.BookUpdateForm
import com.tokumura.librarian.repository.BookRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class BookServiceTest {
    private val bookRepo = mock<BookRepository>()
    private val bookService = BookService(bookRepo)

    @Test
    fun getBooksTest() {
        val book1 = Book(1, "Guri and Gura", 1)
        val book2 = Book(2, "The Sky Blue Seed", 1)
        val expected = listOf(book1, book2)
        whenever(bookRepo.findAll()).thenReturn(expected)

        val books = bookService.getBooks()
        verify(bookRepo).findAll()
        Assertions.assertEquals(books, expected)
    }

    @Test
    fun getBooksByAuthorIdTest() {
        val authorId = 1
        val book1 = Book(1, "Guri and Gura", 1)
        val book2 = Book(2, "The Sky Blue Seed", 1)
        val book3 = Book(3, "The Little Prince", 2)
        val expected = listOf(book1, book2)
        val notExpected = listOf(book1, book3)
        whenever(bookRepo.findAllByAuthorId(authorId)).thenReturn(expected)

        val books = bookService.getBooksByAuthor(authorId)
        verify(bookRepo).findAllByAuthorId(authorId)
        Assertions.assertEquals(books, expected)
        Assertions.assertNotEquals(books, notExpected)
    }

    @Test
    fun getBookTest() {
        val expected = Book(1, "Guri and Gura", 1)
        whenever(bookRepo.findById(1)).thenReturn(expected)

        val author = bookService.getBook(1)
        verify(bookRepo).findById(1)
        Assertions.assertEquals(author, expected)
    }

    @Test
    fun createBookTest() {
        val createForm = BookCreateForm("Guri and Gura", 1)
        val expected = Book(1, "Guri and Gura", 1)
        val book = Book("Guri and Gura", 1)
        whenever(bookRepo.create(book)).thenReturn(expected)

        val authorCreated = bookService.createBook(createForm)
        verify(bookRepo).create(book)
        Assertions.assertEquals(authorCreated.title, expected.title)
        Assertions.assertEquals(authorCreated.authorId, expected.authorId)
    }

    @Test
    fun updateBookTest() {
        val updateId = 1
        val updateForm = BookUpdateForm("Guri and Gura", 1)
        val expected = Book(updateId, "Guri and Gura", 1)
        val book = Book(updateId, "Guri and Gura", 1)
        whenever(bookRepo.update(book)).thenReturn(expected)

        val authorUpdated = bookService.updateBook(1, updateForm)
        verify(bookRepo).update(book)
        Assertions.assertEquals(authorUpdated.id, expected.id)
        Assertions.assertEquals(authorUpdated.title, expected.title)
        Assertions.assertEquals(authorUpdated.authorId, expected.authorId)
    }

    @Test
    fun deleteBookTest() {
        val expected = 1
        whenever(bookRepo.delete(1)).thenReturn(1)

        val deleteCount = bookService.deleteBook(1)
        verify(bookRepo).delete(1)
        Assertions.assertEquals(deleteCount, expected)
    }
}