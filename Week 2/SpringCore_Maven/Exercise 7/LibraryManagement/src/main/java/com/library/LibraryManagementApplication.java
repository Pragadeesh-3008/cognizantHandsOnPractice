package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("--- Loading Application Context ---");
        // Load context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("--- Application Context Loaded ---");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute service method
        bookService.execute();

        System.out.println("Exercise 7: Constructor and Setter Injection Verified Successfully!");
    }
}
