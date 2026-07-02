package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean (id is usually camelCase class name by default: bookService)
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute service business logic
        bookService.execute();

        System.out.println("Exercise 6: Annotation-Based Configuration Verified Successfully!");
    }
}
