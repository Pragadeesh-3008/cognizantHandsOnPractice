package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean (which is wrapped in an AOP proxy)
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute service method to trigger AOP interceptors
        bookService.execute();

        System.out.println("Exercise 3: Spring AOP Logging Tested Successfully!");
    }
}
