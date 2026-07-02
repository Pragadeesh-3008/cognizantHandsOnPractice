package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection via @Autowired
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("BookService (Annotated): Service executing...");
        if (bookRepository != null) {
            bookRepository.save();
        } else {
            System.out.println("BookService (Annotated): BookRepository not injected.");
        }
    }
}
