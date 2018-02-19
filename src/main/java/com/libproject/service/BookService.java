package com.libproject.service;

import com.libproject.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 12.02.2018.
 */
@Service
public interface BookService {

    Long createBook(String name, String author);

    List<Book> getAll();

    List<Book> getBooksByName(String name);

    List<Book> getBooksByAuthor(String author);

}
