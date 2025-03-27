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
            throw new RuntimeException("Book not found with bookID: " + bookId);
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

    public Book updateBook(String bookId , Book bookDetails)
    {
        Optional<Book> optionalBook = bookRepository.findBookByBookId(bookId);

        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found! with bookID: " + bookId);
        }
        Book existingBook = optionalBook.get();

        existingBook.setBookId(bookDetails.getBookId());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setGenre(bookDetails.getGenre());
        existingBook.setAvailablilityStatus(bookDetails.getAvailablilityStatus());

        return bookRepository.save(existingBook);
    }

    public void deleteBookById(String bookId) {
        Optional<Book> optionalBook = bookRepository.findBookByBookId(bookId);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(optionalBook.get().getId());

        } else {
            throw new RuntimeException("Book not found with bookId" + bookId);
        }
    }





}

