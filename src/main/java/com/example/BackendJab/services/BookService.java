package com.example.BackendJab.services;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.repositories.BookRepository;
import com.example.BackendJab.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);


    public ResponseEntity<Object> getAllBooks() {
        if(bookRepository.findAll().isEmpty()){
            logger.info("No Books Found");
        }
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public ResponseEntity<Object> getAllBooksByCategory(Long categoryID) {
        List<Book> booksByCategory = bookRepository.findBooksByCategoryID(categoryID);
        return ResponseEntity.ok().body(booksByCategory);
    }

    public ResponseEntity<Object> getAllBooksByName(String name) {
        List<Book> booksByName = bookRepository.findBooksByName(name);
        return  ResponseEntity.ok(booksByName);
    }


    public ResponseEntity<Object> createBook(Book book) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        responseHeaders.setLocation(location);

        bookRepository.save(book);
        logger.info("Book Created");
        return new ResponseEntity<>(null,responseHeaders, HttpStatus.CREATED);

    }


    public ResponseEntity<Object> updateBook(Book book, Long bookID) {
        logger.info("Book Successfully Modified");
        return ResponseEntity.ok(bookRepository.save(book));

    }

    public ResponseEntity<Object> deleteBook(Long bookID) {
        if (bookRepository.findById(bookID).isEmpty()) {
            logger.info("Unable to Delete Book");
        }
        logger.info("Deleted Book");
        bookRepository.deleteById(bookID);

        return ResponseEntity.ok(HttpStatus.OK);
    }




}
