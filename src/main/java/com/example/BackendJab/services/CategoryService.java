package com.example.BackendJab.services;


import com.example.BackendJab.models.Book;
import com.example.BackendJab.models.Category;
import com.example.BackendJab.repositories.BookRepository;
import com.example.BackendJab.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public List<Category> getAllCategories() {
        if(categoryRepository.findAll().isEmpty()){
            logger.info("No Categories Found");
        }

        logger.info("Categories Found");
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long Id) {
        if(bookRepository.findAll().isEmpty()){
            logger.info("No Books Found");
        }
        Category category = categoryRepository.findById(Id).orElseThrow(null);
        return category;
    }

    public List<String> getAllCategoryNames() {
        if(categoryRepository.findAll().isEmpty()){
            logger.info("No Categories Found");
        }
        logger.info("Category Names Found");
        return categoryRepository.findAllCategoryNames();
    }

    public Category createCategory(Category category) {
        logger.info("Category Created");
        return categoryRepository.save(category);

    }

    public Category updateCategory(Category category, Long Id) {
        logger.info("Category Modified");
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long Id) {
        logger.info("Deleted Category");
        categoryRepository.deleteById(Id);
    }

    public List<Category> getAllBooksByName(String name) {
        List<Category> booksByName = categoryRepository.findBooksByName(name);
        return booksByName;
    }

    public Category getCategoryByBookId(Long Id) {
      logger.info("Found Category At Book ID");
        Category category;
        for (Book book: bookRepository.findAll()) {
            if(book.getId().equals(Id)){
                category = book.getCategory();
                return category;
            }
        }
        return null;
    }
}
