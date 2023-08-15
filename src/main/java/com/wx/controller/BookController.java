package com.wx.controller;

import com.wx.domain.Book;
import com.wx.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Fetching all books");
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        log.info("Fetching book by ID: {}", id);
        Book book = bookService.getBookById(id);
        if (book != null) {
            log.info("Book found: {}", book);
            return ResponseEntity.ok(book);
        } else {
            log.info("Book not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("Creating book: {}", book);
        Book createdBook = bookService.createBook(book);
        log.info("Book created: {}", createdBook);
        return ResponseEntity.status(201).body(createdBook);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        log.info("Updating book with ID {}: {}", id, book);
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            log.info("Book updated: {}", updatedBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            log.info("Book not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        log.info("Deleting book with ID: {}", id);
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            log.info("Book deleted with ID: {}", id);
            return ResponseEntity.noContent().build();
        } else {
            log.info("Book not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
