package com.tokumura.librarian.presentation.form.book

import com.tokumura.librarian.domain.model.Book

data class BookResponse (
    val id: Int,
    val title: String,
    val authorId: Int
) {
    constructor(book: Book) : this(book.id!!, book.title, book.authorId)
}