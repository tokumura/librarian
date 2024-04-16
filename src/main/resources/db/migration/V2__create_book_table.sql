CREATE TABLE book
(
    id SERIAL NOT NULL,
    title TEXT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY(id)
);
CREATE INDEX book_idx1 ON book(author_id);
ALTER TABLE book ADD CONSTRAINT book_fk1 FOREIGN KEY (author_id) REFERENCES author(id) ;