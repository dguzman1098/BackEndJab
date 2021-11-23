package com.example.BackendJab.repositories;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM CATEGORY", nativeQuery = true)
    List<String> findAllCategoryNames();



}
