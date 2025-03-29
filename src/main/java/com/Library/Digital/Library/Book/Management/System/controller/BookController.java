package com.Library.Digital.Library.Book.Management.System.controller;

import com.Library.Digital.Library.Book.Management.System.entity.Book;
import com.Library.Digital.Library.Book.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digital-library")
public class BookController {


    @Autowired
    private BookService bookService;


//   API to Retrieve all books from the database.
    @GetMapping("/getAllBooks")
    public List<Book> viewAllBooks()
    {
        return  bookService.getAll();
    }

//  API to  Add a new book to the database.
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return new ResponseEntity<>(book , HttpStatus.CREATED);
    }


//  API to  Retrieve a book by its unique ID.
    @GetMapping("/searchBookById/{bookId}")
    public ResponseEntity<Book> searchBookById(@PathVariable String bookId)
    {
        try {
            Book book = bookService.findById(bookId);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//   API to Retrieve a book by its title.
    @GetMapping("/searchBookByTitle/{title}")
    public ResponseEntity<Book> searchBookByTitle(@PathVariable String title) {
        try {
            Book book = bookService.findByTitle(title);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//  API to  Update details of an existing book.
    @PutMapping("/updateBookById/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable String bookId , @RequestBody Book bookDetails)
    {
        try{
            bookService.updateBook(bookId , bookDetails);
            return new ResponseEntity<>("Book updated successfully" , HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


//  API to  Delete a book by its ID.
    @DeleteMapping("/deleteBookById/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId) {
        try {
            bookService.deleteBookById(bookId);
            return ResponseEntity.ok("Book deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
