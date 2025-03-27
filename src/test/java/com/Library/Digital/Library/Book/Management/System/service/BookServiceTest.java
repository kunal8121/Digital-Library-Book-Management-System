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

import static org.junit.jupiter.api.Assertions.assertEquals;
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




}
