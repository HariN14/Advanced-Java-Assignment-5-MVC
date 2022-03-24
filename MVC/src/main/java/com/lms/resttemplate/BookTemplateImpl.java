package com.lms.resttemplate;

import com.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class BookTemplateImpl implements BookTemplate{

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://localhost:7070/lms/books";

    @Override
    public List<Book> getBooks() {
        ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity(URL,Book[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public Book getBook(Long id) {
        String url = URL + "/" + id;
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity(url,Book.class);
        return responseEntity.getBody();
    }

    @Override
    public void addBook(Book book) {
        restTemplate.postForEntity(URL, book, Long.class);
    }

    @Override
    public void editBook(Book book) {
        restTemplate.put(URL, book);
    }

    @Override
    public void deleteBook(Long id) {
        restTemplate.delete(URL + "/" + id);
    }
}
