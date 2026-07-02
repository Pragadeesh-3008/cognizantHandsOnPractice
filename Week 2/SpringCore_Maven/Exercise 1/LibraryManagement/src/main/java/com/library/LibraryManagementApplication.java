package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context from XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test BookRepository bean
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.save();

        // Retrieve and test BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.execute();

        System.out.println("Exercise 1: Spring Context Loaded and Beans Tested Successfully!");
    }
}
