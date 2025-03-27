package com.Library.Digital.Library.Book.Management.System.controller;

import com.Library.Digital.Library.Book.Management.System.entity.Book;
import com.Library.Digital.Library.Book.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/allbook")
    public List<Book> viewAllBooks()
    {
        return  bookService.getAll();
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> searchBookById(@PathVariable String bookId)
    {
        Optional<Book> existing = bookService.findById(bookId);

        if(existing.isPresent())
        {
            return new ResponseEntity<>(existing.get() , HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
