package com.libproject.service;

import com.libproject.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 12.02.2018.
 */
@Service
public interface BookService {

    public Long createBook(String name, String author);

    public List<Book> getAll();

    public List<Book> getBooksByName(String name);

    public List<Book> getBooksByAuthor(String author);

}
