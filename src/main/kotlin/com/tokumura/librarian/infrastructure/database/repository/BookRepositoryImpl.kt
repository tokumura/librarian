package com.tokumura.librarian.infrastructure.database.repository

import com.tokumura.librarian.domain.model.Book
import com.tokumura.librarian.infrastructure.database.jooq.tables.records.BookRecord
import com.tokumura.librarian.infrastructure.database.jooq.tables.references.BOOK
import com.tokumura.librarian.repository.BookRepository
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
    private val dslContext: DSLContext
) : BookRepository {
    override fun findAll(): List<Book> {
        return dslContext.selectFrom(BOOK)
            .orderBy(BOOK.ID)
            .fetch()
            .map { toModel(it) }
    }

    override fun findById(id: Int): Book {
        return dslContext.selectFrom(BOOK)
            .where(BOOK.ID.eq(id))
            .fetchOne()
            .let { toModel(it) }
    }

    override fun findAllByAuthorId(authorId: Int): List<Book> {
        return dslContext.selectFrom(BOOK)
            .where(BOOK.AUTHOR_ID.eq(authorId))
            .fetch()
            .map { toModel(it) }
    }

    override fun create(book: Book): Book {
        return dslContext.insertInto(BOOK)
            .set(BOOK.TITLE, book.title)
            .set(BOOK.AUTHOR_ID, book.authorId)
            .returning(BOOK.ID, BOOK.TITLE, BOOK.AUTHOR_ID)
            .fetchOne()
            .let { toModel(it) }
    }

    override fun update(book: Book): Book {
        return dslContext.update(BOOK)
            .set(BOOK.TITLE, book.title)
            .set(BOOK.AUTHOR_ID, book.authorId)
            .where(BOOK.ID.eq(book.id))
            .returning(BOOK.ID, BOOK.TITLE, BOOK.AUTHOR_ID)
            .fetchOne()
            .let { toModel(it) }
    }

    override fun delete(id: Int): Int {
        return dslContext.deleteFrom(BOOK)
            .where(BOOK.ID.eq(id))
            .execute()
    }

    private fun toModel(r: BookRecord?): Book {
        r?.id ?: throw RuntimeException("Book ID is null")
        return Book(r.id!!, r.title, r.authorId)
    }
}