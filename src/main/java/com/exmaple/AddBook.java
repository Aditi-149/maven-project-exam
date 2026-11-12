package com.exmaple;


import java.util.HashMap;
import java.util.Map;

public class AddBook {

    private Map<Integer, Book> books = new HashMap<>();

    // Inner Book class
    static class Book {
        int bookId;
        String title;
        boolean available;

        Book(int bookId, String title) {
            this.bookId = bookId;
            this.title = title;
            this.available = true;
        }
    }

    // Add a new book
    public void addBook(int bookId, String title) {
        if (books.containsKey(bookId)) {
            throw new IllegalArgumentException("Book ID already exists");
        }

        books.put(bookId, new Book(bookId, title));
    }

    // Search book using ID
    public Book searchBook(int bookId) {
        return books.get(bookId);
    }

    // Issue a book
    public boolean issueBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            return false;
        }

        if (!book.available) {
            return false;
        }

        book.available = false;
        return true;
    }

    // Return an issued book
    public boolean returnBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null || book.available) {
            return false;
        }

        book.available = true;
        return true;
    }

    // Check book availability
    public boolean isAvailable(int bookId) {
        Book book = books.get(bookId);
        return book != null && book.available;
    }
}
