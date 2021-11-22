package com.example.BackendJab.services;


import com.example.BackendJab.models.Book;
import com.example.BackendJab.models.Category;
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


@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public ResponseEntity<Object> getAllCategories() {
        if(categoryRepository.findAll().isEmpty()){
            logger.info("No Categories Found");
        }

        logger.info("Categories Found");
        return ResponseEntity.ok().body(categoryRepository.findAll());
    }

    public ResponseEntity<Object> getAllCategoryNames() {
        if(categoryRepository.findAll().isEmpty()){
            logger.info("No Categories Found");
        }

        logger.info("Category Names Found");
        return ResponseEntity.ok(categoryRepository.findAllCategoryNames());
    }

    public ResponseEntity<Object> createCategory(Category category) {
        logger.info("Category Created");

        HttpHeaders responseHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        responseHeaders.setLocation(location);

        return ResponseEntity.created(location).body(categoryRepository.save(category));

    }

    public ResponseEntity<Object> updateCategory(Category category, Long categoryID) {
        logger.info("Category Modified");
        return ResponseEntity.ok().body(categoryRepository.save(category));

    }

    public ResponseEntity<Object> deleteCategory(Long id) {
        logger.info("Deleted Category");
        categoryRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object>  addBookToCategory(Long categoryID, Long bookID){
        Category category = categoryRepository.findById(categoryID).get();
        Book book = bookRepository.findById(bookID).get();
        category.addBook(book);
        return ResponseEntity.ok(categoryRepository.save(category));
    }


}
