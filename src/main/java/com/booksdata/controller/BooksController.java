package com.booksdata.controller;

import com.booksdata.entity.Books;
import com.booksdata.service.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BookDataService bookDataService;

    @PostMapping("/addbook")
    public ResponseEntity<String> postingBooks(@RequestBody Books books) {
        try {
            bookDataService.addNewBook(books);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book not created");
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<?> gettingAllBooks() {
        List<Books> books = bookDataService.getBooks();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found");
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<?> gettingBookById(@PathVariable("id") int id) {
        Books book = bookDataService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id " + id + " not found");
        }
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<String> deletingBooks(@PathVariable("id") int id) {
        try {
            bookDataService.deleteBookById(id);
            return ResponseEntity.ok("Book with id " + id + " deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Book with id " + id + " not found");
        }
    }

    @PutMapping("/updateby/{id}")
    public ResponseEntity<?> updatingBooks(@RequestBody Books book, @PathVariable int id) {
        try {
            Books updatedBook = bookDataService.updateById(book, id);
            if (updatedBook == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Book with ID " + id + " has been updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update book with ID " + id + ".");
        }
    }
}
