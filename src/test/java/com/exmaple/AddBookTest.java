package com.exmaple;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddBookTest {

    // Test adding and searching for a book
    @Test
    public void testAddAndSearchBook() {
    	AddBook library = new AddBook();

        library.addBook(101, "Java Programming");

        AddBook.Book book = library.searchBook(101);

        assertNotNull(book);
        assertEquals(101, book.bookId);
        assertEquals("Java Programming", book.title);
        assertTrue(book.available);
    }

    // Test duplicate book ID
    @Test
    public void testDuplicateBookId() {
    	AddBook library = new AddBook();

        library.addBook(101, "Java Programming");

        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(101, "Python Programming");
        });
    }

    // Test issuing an available book
    @Test
    public void testIssueAvailableBook() {
    	AddBook library = new AddBook();

        library.addBook(102, "Database Management");

        assertTrue(library.issueBook(102));
        assertFalse(library.isAvailable(102));
    }

    // Test issuing an already-issued book
    @Test
    public void testIssueAlreadyIssuedBook() {
    	AddBook library = new AddBook();

        library.addBook(103, "Operating Systems");

        assertTrue(library.issueBook(103));

        assertFalse(library.issueBook(103));
    }

    // Test returning an issued book
    @Test
    public void testReturnBook() {
    	AddBook library = new AddBook();

        library.addBook(104, "Computer Networks");

        library.issueBook(104);

        assertTrue(library.returnBook(104));
        assertTrue(library.isAvailable(104));
    }

    // Test returning a book that is not issued
    @Test
    public void testReturnAvailableBook() {
    	AddBook library = new AddBook();

        library.addBook(105, "Software Engineering");

        assertFalse(library.returnBook(105));
        assertTrue(library.isAvailable(105));
    }

    // Test searching for a non-existing book
    @Test
    public void testSearchNonExistingBook() {
    	AddBook library = new AddBook();

        assertNull(library.searchBook(999));
    }
}
