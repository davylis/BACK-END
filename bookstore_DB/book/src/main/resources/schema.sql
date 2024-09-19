CREATE TABLE IF NOT EXISTS book (
    book_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) DEFAULT NULL,
    author varchar(50) DEFAULT NULL,
    publication_year int(4) DEFAULT NULL,
    isbn varchar(50) DEFAULT NULL,
    price double DEFAULT NULL
);
