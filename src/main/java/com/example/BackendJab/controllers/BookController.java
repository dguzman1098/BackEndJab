package com.example.BackendJab.controllers;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Object> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/categories/{categoryID}")
    public ResponseEntity<Object> getAllBooksByCategoryID(@PathVariable Long categoryID){
        return bookService.getAllBooksByCategory(categoryID);
    }

    @GetMapping("/books/{name}")
    public ResponseEntity<Object> getAllBooksByName(@PathVariable String name){
        return bookService.getAllBooksByName(name);
    }

    @PostMapping("/books")
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/books/{bookID}")
    public ResponseEntity<Object> updateBook(@Valid @RequestBody Book book, @PathVariable Long bookID){
        return bookService.updateBook(book, bookID);
    }

    @DeleteMapping("books/{bookID}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long bookID){
        return bookService.deleteBook(bookID);
    }


}
