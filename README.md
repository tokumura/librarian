# Librarian

## 概要

書籍管理できるサンプルシステム

著者情報・書籍情報を管理するREST APIアプリケーション

### 提供機能

- 著者情報の取得、新規追加、更新、削除
- 書籍情報の取得、新規追加、更新、削除
- 任意著者の書籍情報の取得

## API

### 著者情報

|                                                                                   | メソッド   | URI                |
|-----------------------------------------------------------------------------------|--------|--------------------|
| 全ての著者情報を取得                                                                        | GET    | /authors           |
| 特定の著者情報を取得                                                                        | GET    | /author/{authorId} |
| [著者情報を新規追加](https://github.com/tokumura/librarian/blob/main/params.md#postauthor) | POST   | /author            |
| [著者情報を更新](https://github.com/tokumura/librarian/blob/main/params.md#putauthor)                                                                       | PUT    | /author/{authorId} |
| 著者情報を削除                                                                           | DELETE | /author/{authorId} |

### 書籍情報

|                                                                                 | メソッド  | URI                           |
|---------------------------------------------------------------------------------|---------|--------------------------------|
| 全ての書籍情報を取得                                                                      | GET     | /books                        |
| 特定著者の全ての書籍情報を取得                                                                 | GET     | /books_by_author/{authorId}   |
| 特定の書籍情報を取得                                                                      | GET     | /book/{bookId}                |
| [書籍情報を新規追加](https://github.com/tokumura/librarian/blob/main/params.md#postbook) | POST    | /book                         |
| [書籍情報を更新](https://github.com/tokumura/librarian/blob/main/params.md#putbook)                                                                     | PUT     | /book/{bookId}                |
| 書籍情報を削除                                                                         | DELETE  | /book/{bookId}                |

## Library & Version

- Java 21
- Kotlin 1.9.23
- Spring Boot 3.2.4
- Gradle 8.7
- JOOQ 3.19.7
- Flyway 10.11.0
- Docker Compose
- PostgreSQL latest