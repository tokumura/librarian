package com.tokumura.librarian.domain.model

data class BookWithAuthor(
    val id: Int,
    val title: String,
    val authorId: Int,
    val name: String
)