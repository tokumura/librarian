package com.tokumura.librarian.presentation.form.book

import com.tokumura.librarian.domain.model.BookWithAuthor

data class BookSearchResponse (
    val id: Int,
    val title: String,
    val authorId: Int,
    val authorName: String
) {
    constructor(book: BookWithAuthor) : this(book.id, book.title, book.authorId, book.name)
}