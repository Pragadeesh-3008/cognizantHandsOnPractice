package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("BookService: Delegating work to BookRepository...");
        if (bookRepository != null) {
            bookRepository.save();
        } else {
            System.out.println("BookService: Error - BookRepository dependency not injected!");
        }
    }
}
