package com.libproject.controller;

import com.libproject.model.Book;
import com.libproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Artur on 11.02.2018.
 */
@CrossOrigin
@RestController
public class LibController
{
    private BookService bookService;

    @Autowired
    public LibController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("lib")
    public List<Book> getLib() {
        return this.bookService.getAll();
    }

    @PostMapping("book")
    public Long createBook(@RequestBody Book book) {
        return this.bookService.createBook(book.getName(), book.getAuthor());
    }

    @PostMapping("getBooksByName")
    public List<Book> getBooksByName(@RequestBody String name) {
        return this.bookService.getBooksByName(name);
    }

    @PostMapping("getBooksByAuthor")
    public List<Book> getBooksByAuthor(@RequestBody String author) {
        return this.bookService.getBooksByAuthor(author);
    }

}
