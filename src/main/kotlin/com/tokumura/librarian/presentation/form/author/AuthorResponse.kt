package com.tokumura.librarian.presentation.form.author

import com.tokumura.librarian.domain.model.Author

data class AuthorResponse (
    val id: Int,
    val name: String,
    val url: String?
) {
    constructor(author: Author) : this(author.id!!, author.name, author.url)
}