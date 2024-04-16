package com.tokumura.librarian.infrastructure.database.repository

import com.tokumura.librarian.domain.model.Author
import com.tokumura.librarian.infrastructure.database.jooq.tables.records.AuthorRecord
import com.tokumura.librarian.infrastructure.database.jooq.tables.references.AUTHOR
import com.tokumura.librarian.repository.AuthorRepository
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class AuthorRepositoryImpl(
    private val dslContext: DSLContext
) : AuthorRepository {
    override fun findAll(): List<Author> {
        return dslContext.selectFrom(AUTHOR)
            .orderBy(AUTHOR.ID)
            .fetch()
            .map { toModel(it) }
    }

    override fun findById(id: Int): Author {
        return dslContext.selectFrom(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .fetchOne()
            .let { toModel(it) }
    }

    override fun create(author: Author): Author {
        return dslContext.insertInto(AUTHOR)
            .set(AUTHOR.NAME, author.name)
            .set(AUTHOR.URL, author.url)
            .returning(AUTHOR.ID, AUTHOR.NAME)
            .fetchOne()
            .let { toModel(it) }
    }

    override fun update(author: Author): Author {
        return dslContext.update(AUTHOR)
            .set(AUTHOR.NAME, author.name)
            .set(AUTHOR.URL, author.url)
            .where(AUTHOR.ID.eq(author.id))
            .returning(AUTHOR.ID, AUTHOR.NAME)
            .fetchOne()
            .let { toModel(it) }
    }

    override fun delete(id: Int): Int {
        return dslContext.deleteFrom(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .execute()
    }

    private fun toModel(r: AuthorRecord?): Author {
        r?.id ?: throw RuntimeException("Author ID is null")
        return Author(r.id!!, r.name, r.url)
    }
}