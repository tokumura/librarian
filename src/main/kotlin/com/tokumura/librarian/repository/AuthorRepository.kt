package com.tokumura.librarian.repository

import com.tokumura.librarian.domain.model.Author

interface AuthorRepository {
    fun findAll(): List<Author>
    fun findById(id: Int): Author
    fun create(author: Author): Author
    fun update(author: Author): Author
    fun delete(id: Int): Int
}