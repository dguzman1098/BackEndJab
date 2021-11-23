package com.example.BackendJab.controllers;


import com.example.BackendJab.models.Category;
import com.example.BackendJab.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/categories/{Id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long Id){
        return ResponseEntity.ok(categoryService.getCategoryById(Id));
    }

    @GetMapping("/categories/names")
    public ResponseEntity<Object> getAllCategoryNames(){
        return ResponseEntity.ok(categoryService.getAllCategoryNames());
    }

    @GetMapping("categories/books/{Id}")
    public ResponseEntity<Object> getCategoryByBookId(@PathVariable Long Id){
        return ResponseEntity.ok(categoryService.getCategoryByBookId(Id));
    }

    @GetMapping("/books/search/{name}")
    public ResponseEntity<?> getBooksByName(String name){
        return ResponseEntity.ok(categoryService.getAllBooksByName(name));
    }

    @PostMapping("/categories")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.updateCategory(category, categoryId));
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
