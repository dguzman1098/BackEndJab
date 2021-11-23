package com.example.BackendJab.repositories;

import com.example.BackendJab.models.Book;
import com.example.BackendJab.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query(value = "SELECT * FROM BOOK WHERE CATEGORY_ID = ?1", nativeQuery = true)
    List<Book> getBooksByCategoryId(Long categoryId);

    @Query("SELECT b FROM Book b WHERE b.name LIKE %?1%")
    List<Book> findBooksByName(String name);




}
