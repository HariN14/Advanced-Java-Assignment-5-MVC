package com.lms.resttemplate;

import com.lms.model.Book;

import java.util.List;

public interface BookTemplate {

    List<Book> getBooks();

    Book getBook(Long id);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(Long id);
}
