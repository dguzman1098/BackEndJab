package com.example.BackendJab.controllers;


import com.example.BackendJab.models.Category;
import com.example.BackendJab.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Object> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/names")
    public ResponseEntity<Object> getAllCategoryNames(){
        return categoryService.getAllCategoryNames();
    }

    @PostMapping("/categories")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/categories/{categoryID}/books/{bookID}")
    ResponseEntity<Object> addBookToCategory(@PathVariable Long categoryID, @PathVariable Long bookID){
        return categoryService.addBookToCategory(categoryID, bookID);
    }

    @PutMapping("/categories/{categoryID}")
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryID){
        return categoryService.updateCategory(category, categoryID);
    }

    @DeleteMapping("/categories/{categoryID}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long categoryID){
        return categoryService.deleteCategory(categoryID);
    }
}
