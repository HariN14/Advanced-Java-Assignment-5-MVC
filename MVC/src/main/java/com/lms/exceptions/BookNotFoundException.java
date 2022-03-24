package com.lms.exceptions;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String message) {
        super(message);
    }
}
