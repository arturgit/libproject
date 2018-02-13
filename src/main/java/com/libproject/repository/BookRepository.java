package com.libproject.repository;

import com.libproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Artur on 12.02.2018.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findAllByAuthor(String author);

    public List<Book> findAllByName(String name);

}
