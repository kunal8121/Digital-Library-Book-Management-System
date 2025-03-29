package com.Library.Digital.Library.Book.Management.System.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Book ID must be alphanumeric (no special characters)")
    @Column(nullable = false , unique = true)
    private String bookId;

    @NotBlank(message = "Title cannot be empty")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Author cannot be blank")                                @Pattern(regexp = "\\d{3}-\\d{10}", message = "ISBN must be in format 123-1234567890")
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "Genre cannot be blank")
    @Column(nullable = false)
    private String genre;

    @NotBlank(message = "Availability status cannot be blank")
    @Column(nullable = false)
    private String availablilityStatus;

}
