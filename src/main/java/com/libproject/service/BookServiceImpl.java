package com.libproject.service;

import com.libproject.model.Book;
import com.libproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 12.02.2018.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Long createBook(String name, String author) {
        Book book = this.bookRepository.save(new Book(name, author));
        return book.getId();
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return this.bookRepository.findAllByName(name);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return this.bookRepository.findAllByAuthor(author);
    }

}
