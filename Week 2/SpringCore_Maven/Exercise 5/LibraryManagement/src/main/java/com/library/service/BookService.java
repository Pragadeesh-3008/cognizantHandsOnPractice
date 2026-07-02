package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for BookRepository to configure via IoC container XML
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("BookService: Service executing...");
        if (bookRepository != null) {
            bookRepository.save();
        } else {
            System.out.println("BookService: Dependency BookRepository not injected.");
        }
    }
}
