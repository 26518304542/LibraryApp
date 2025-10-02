package com.organization.LibraryApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.organization.LibraryApp.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByCategoryContainingIgnoreCase(String category);

}
