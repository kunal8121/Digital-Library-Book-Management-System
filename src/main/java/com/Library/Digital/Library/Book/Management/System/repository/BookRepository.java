package com.Library.Digital.Library.Book.Management.System.repository;

import com.Library.Digital.Library.Book.Management.System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByBookId(String bookId);

    Optional<Book> findBookByTitle(String title);
}
