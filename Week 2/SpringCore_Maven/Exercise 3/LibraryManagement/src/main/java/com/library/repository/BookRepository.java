package com.library.repository;

public class BookRepository {
    public void save() {
        System.out.println("BookRepository: Saving book to the database...");
        try {
            // Simulate database latency
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
