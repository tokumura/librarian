package com.tokumura.librarian.presentation.controller

import com.tokumura.librarian.application.service.AuthorService
import com.tokumura.librarian.presentation.form.author.AuthorCreateForm
import com.tokumura.librarian.presentation.form.author.AuthorUpdateForm
import com.tokumura.librarian.presentation.form.author.AuthorResponse
import org.springframework.web.bind.annotation.*

@RestController
class AuthorController(
    private val authorService: AuthorService
) {
    @GetMapping("/authors")
    fun getAuthors(): List<AuthorResponse> {
        val authors = authorService.getAuthors()
        return authors.map { AuthorResponse(it) }
    }

    @GetMapping("/author/{id}")
    fun getAuthor(
        @PathVariable("id") id: Int
    ): AuthorResponse {
        val author = authorService.getAuthor(id)
        return AuthorResponse(author)
    }

    @PostMapping("/author")
    fun createAuthor(
        @RequestBody form: AuthorCreateForm
    ): AuthorResponse
    {
        val authorCreated = authorService.createAuthor(form)
        return AuthorResponse(authorCreated)
    }

    @PutMapping("/author/{id}")
    fun updateAuthor(
        @PathVariable("id") id: Int,
        @RequestBody form: AuthorUpdateForm
    ): AuthorResponse {
        val authorUpdated = authorService.updateAuthor(id, form)
        return AuthorResponse(authorUpdated)
    }

    @DeleteMapping("/author/{id}")
    fun deleteAuthor(
        @PathVariable("id") id: Int): Int
    {
        return authorService.deleteAuthor(id)
    }
}