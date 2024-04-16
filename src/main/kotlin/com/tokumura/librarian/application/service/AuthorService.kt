package com.tokumura.librarian.application.service

import com.tokumura.librarian.domain.model.Author
import com.tokumura.librarian.presentation.form.author.AuthorCreateForm
import com.tokumura.librarian.presentation.form.author.AuthorUpdateForm
import com.tokumura.librarian.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorService(
    private val authorRepo: AuthorRepository
) {
    @Transactional(readOnly = true)
    fun getAuthors() : List<Author> = authorRepo.findAll()

    @Transactional(readOnly = true)
    fun getAuthor(id: Int) = authorRepo.findById(id)

    @Transactional
    fun createAuthor(form: AuthorCreateForm) : Author {
        val author = Author(form.name, form.url)
        return authorRepo.create(author)
    }

    @Transactional
    fun updateAuthor(id: Int, form: AuthorUpdateForm) : Author {
        val author = Author(id, form.name, form.url)
        return authorRepo.update(author)
    }

    @Transactional
    fun deleteAuthor(id: Int) = authorRepo.delete(id)

}