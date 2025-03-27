package com.Library.Digital.Library.Book.Management.System.service;

import com.Library.Digital.Library.Book.Management.System.entity.Book;
import com.Library.Digital.Library.Book.Management.System.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp()
    {
        book1 = new Book(1L, "B001", "Java Programming", "James Gosling", "Technology", "Available");
        book2 = new Book(2L, "B002", "Python Basics", "Guido van Rossum", "Technology", "Available");
    }

    @Test
    void testGetAll(){
      List<Book> bookList = Arrays.asList(book1 , book2);

      when(bookRepository.findAll()).thenReturn(bookList);

      List<Book> result = bookService.getAll();assertEquals("Java Programming", result.get(0).getTitle());
        assertEquals("Python Basics", result.get(1).getTitle());

      assertEquals(2 , result.size());
        assertEquals("Java Programming", result.get(0).getTitle());
        assertEquals("Python Basics", result.get(1).getTitle());

        verify(bookRepository , times(1)).findAll();
    }

    @Test
    void testAddBook() {

        when(bookRepository.save(book1)).thenReturn(book1);

        Book savedBook = bookService.addBook(book1);

        assertEquals(book1, savedBook);
        verify(bookRepository, times(1)).save(book1);
    }
    @Test
    void testFindById_BookExists() {

        when(bookRepository.findBookByBookId("B001")).thenReturn(Optional.of(book1));


        Book foundBook = bookService.findById("B001");


        assertNotNull(foundBook);
        assertEquals("Java Programming", foundBook.getTitle());
        assertEquals("James Gosling", foundBook.getAuthor());
        assertEquals("Technology", foundBook.getGenre());
        assertEquals("Available", foundBook.getAvailablilityStatus());


        verify(bookRepository, times(1)).findBookByBookId("B001");
    }

    @Test
    void testFindById_BookNotFound() {

        when(bookRepository.findBookByBookId("B003")).thenReturn(Optional.empty());


        RuntimeException exception = assertThrows(RuntimeException.class, () -> bookService.findById("B003"));


        assertEquals("Book not found with bookID: B003", exception.getMessage());


        verify(bookRepository, times(1)).findBookByBookId("B003");
    }



    @Test
    void testFindByTitle_BookExists() {
        // Mock repository to return a book when searched by title
        when(bookRepository.findBookByTitle("Java Programming")).thenReturn(Optional.of(book1));

        // Call the service method
        Book foundBook = bookService.findByTitle("Java Programming");

        // Assertions
        assertNotNull(foundBook);
        assertEquals("Java Programming", foundBook.getTitle());
        assertEquals("James Gosling", foundBook.getAuthor());
        assertEquals("Technology", foundBook.getGenre());
        assertEquals("Available", foundBook.getAvailablilityStatus());

        // Verify interaction with repository
        verify(bookRepository, times(1)).findBookByTitle("Java Programming");
    }

    @Test
    void testFindByTitle_BookNotFound() {

        when(bookRepository.findBookByTitle("C++ Basics")).thenReturn(Optional.empty());


        RuntimeException exception = assertThrows(RuntimeException.class, () -> bookService.findByTitle("C++ Basics"));


        assertEquals("Book not found with title: C++ Basics", exception.getMessage());


        verify(bookRepository, times(1)).findBookByTitle("C++ Basics");
    }

    @Test
    void testUpdateBook_BookExists() {
        // Mock existing book in repository
        when(bookRepository.findBookByBookId("B001")).thenReturn(Optional.of(book1));

        // Create updated book details
        Book updatedBookDetails = new Book(1L, "B001", "Advanced Java", "Joshua Bloch", "Programming", "Unavailable");

        // Mock repository save behavior
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBookDetails);

        // Call the service method
        Book updatedBook = bookService.updateBook("B001", updatedBookDetails);

        // Assertions
        assertNotNull(updatedBook);
        assertEquals("B001", updatedBook.getBookId());
        assertEquals("Advanced Java", updatedBook.getTitle());
        assertEquals("Joshua Bloch", updatedBook.getAuthor());
        assertEquals("Programming", updatedBook.getGenre());
        assertEquals("Unavailable", updatedBook.getAvailablilityStatus());

        // Verify repository interactions
        verify(bookRepository, times(1)).findBookByBookId("B001");
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void testDeleteBookById_BookExists() {

        when(bookRepository.findBookByBookId("B001")).thenReturn(Optional.of(book1));


        bookService.deleteBookById("B001");


        verify(bookRepository, times(1)).deleteById(book1.getId());
        verify(bookRepository, times(1)).findBookByBookId("B001");
    }





}
