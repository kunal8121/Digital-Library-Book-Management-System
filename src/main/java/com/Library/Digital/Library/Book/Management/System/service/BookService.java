package com.Library.Digital.Library.Book.Management.System.service;

import com.Library.Digital.Library.Book.Management.System.entity.Book;
import com.Library.Digital.Library.Book.Management.System.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll()
    {
        return bookRepository.findAll();
    }

    public Book addBook(Book book)
    {
        return bookRepository.save(book);
    }

    public Book findById(String bookId) {
        Optional<Book> book = bookRepository.findBookByBookId(bookId);

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }

    public Book findByTitle(String title) {
        Optional<Book> book = bookRepository.findBookByTitle(title);

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new RuntimeException("Book not found with title: " + title);
        }
    }


}

