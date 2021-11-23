package com.example.BackendJab.services;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.models.Category;
import com.example.BackendJab.repositories.BookRepository;
import com.example.BackendJab.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public List<Book> getAllBooks() {
        if(bookRepository.findAll().isEmpty()){
            logger.info("No Books Found");
        }
        return bookRepository.findAll();
    }

    public Book getBookById(Long Id) {
        if(bookRepository.findAll().isEmpty()){
            logger.info("No Books Found");
        }
        logger.info("Book By Id Found");
        Book book = bookRepository.findById(Id).orElseThrow(null);
        return book;
    }

    public List<Book> getAllBooksByCategoryId(Long Id) {
        List<Book> booksByCategory = bookRepository.getBooksByCategoryId(Id);
        logger.info("Found All Books by Category");
        return booksByCategory;
    }

    public Book createBook(Book book) {
        //finds the category object in the category repository
        Category category = categoryRepository.findById(book.getCategory().getId()).get();
        book.setCategory(category);
        logger.info("Book Created");
        return bookRepository.save(book);
    }

    public Book updateBook(Book book, Long Id) {
        logger.info("Book Updated");
        return bookRepository.save(book);
    }

    public void deleteBook(Long Id) {
        logger.info("Deleted Book");
        bookRepository.deleteById(Id);
    }

}
