package com.example.BackendJab.controllers;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{Id}")
    public ResponseEntity<?> getBookById(@PathVariable Long Id){
        return ResponseEntity.ok(bookService.getBookById(Id));
    }

    @GetMapping("/books/categories/{categoryId}")
    public ResponseEntity<?> getAllBooksByCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(bookService.getAllBooksByCategoryId(categoryId));
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<?> updateBook(@Valid @RequestBody Book book, @PathVariable Long bookId){
        return ResponseEntity.ok(bookService.updateBook(book, bookId));
    }

    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }

}
