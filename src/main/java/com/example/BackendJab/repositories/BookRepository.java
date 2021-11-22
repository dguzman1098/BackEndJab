package com.example.BackendJab.repositories;

import com.example.BackendJab.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query(value = "SELECT * FROM BOOK WHERE CATEGORY_ID = ?1", nativeQuery = true)
    List<Book> findBooksByCategoryID(Long categoryID);

    @Query(value = "SELECT b.name FROM Book b WHERE b.name LIKE %?1%")
    List<Book> findBooksByName(@Param("name") String name);

}
