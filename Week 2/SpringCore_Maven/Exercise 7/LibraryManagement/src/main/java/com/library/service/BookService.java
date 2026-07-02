package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Default constructor (necessary if Spring needs to instantiate using setter injection only, but we configure constructor injection)
    public BookService() {
        System.out.println("BookService: No-arg constructor called.");
    }

    // Constructor for Constructor Injection
    public BookService(BookRepository bookRepository) {
        System.out.println("BookService: Constructor injection with BookRepository called.");
        this.bookRepository = bookRepository;
    }

    // Setter for Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: Setter injection with BookRepository called.");
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("BookService: Executing business logic...");
        if (bookRepository != null) {
            bookRepository.save();
        } else {
            System.out.println("BookService: Error - BookRepository dependency not injected.");
        }
    }
}
