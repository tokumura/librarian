package com.tokumura.librarian.domain.model

data class Book (
    val id: Int?,
    val title: String,
    val authorId: Int
) {
    constructor(title: String, authorId: Int) : this(null, title, authorId)
}