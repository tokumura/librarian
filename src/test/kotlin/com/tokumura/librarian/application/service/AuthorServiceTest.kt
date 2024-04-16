package com.tokumura.librarian.application.service

import com.tokumura.librarian.domain.model.Author
import com.tokumura.librarian.presentation.form.author.AuthorCreateForm
import com.tokumura.librarian.presentation.form.author.AuthorUpdateForm
import com.tokumura.librarian.repository.AuthorRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class AuthorServiceTest {
    private val authorRepo = mock<AuthorRepository>()
    private val authorService = AuthorService(authorRepo)

    @Test
    fun getAuthorsTest() {
        val author1 = Author(1, "Rieko Nakagawa", "https://rieko.com")
        val author2 = Author(2, "Antoine de Saint-Exupéry", "https://antoine.com")
        val expected = listOf(author1, author2)
        whenever(authorRepo.findAll()).thenReturn(expected)

        val authors = authorService.getAuthors()
        verify(authorRepo).findAll()
        Assertions.assertEquals(authors, expected)
    }

    @Test
    fun getAuthorTest() {
        val expected = Author(1, "Rieko Nakagawa", "https://rieko.com")
        whenever(authorRepo.findById(1)).thenReturn(expected)

        val author = authorService.getAuthor(1)
        verify(authorRepo).findById(1)
        Assertions.assertEquals(author, expected)
    }

    @Test
    fun createAuthorTest() {
        val createForm = AuthorCreateForm("Rieko Nakagawa", "https://rieko.com")
        val expected = Author(1, "Rieko Nakagawa", "https://rieko.com")
        val author = Author("Rieko Nakagawa", "https://rieko.com")
        whenever(authorRepo.create(author)).thenReturn(expected)

        val authorCreated = authorService.createAuthor(createForm)
        verify(authorRepo).create(author)
        Assertions.assertEquals(authorCreated.name, expected.name)
        Assertions.assertEquals(authorCreated.url, expected.url)
    }

    @Test
    fun updateAuhtorTest() {
        val updateId = 1
        val updateForm = AuthorUpdateForm("Rieko Nakagawa", "https://rieko.com")
        val expected = Author(updateId, "Rieko Nakagawa", "https://rieko.com")
        val author = Author(updateId, "Rieko Nakagawa", "https://rieko.com")
        whenever(authorRepo.update(author)).thenReturn(expected)

        val authorUpdated = authorService.updateAuthor(updateId, updateForm)
        verify(authorRepo).update(author)
        Assertions.assertEquals(authorUpdated.name, expected.name)
    }

    @Test
    fun deleteAuthorTest() {
        val expected = 1
        whenever(authorRepo.delete(1)).thenReturn(1)

        val deleteCount = authorService.deleteAuthor(1)
        verify(authorRepo).delete(1)
        Assertions.assertEquals(deleteCount, expected)
    }
}