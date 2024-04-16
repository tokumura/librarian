package com.tokumura.librarian.domain.model

data class Author (
    val id: Int?,
    val name: String,
    val url: String?
) {
    constructor(name: String, url: String) : this(null, name, url)
}