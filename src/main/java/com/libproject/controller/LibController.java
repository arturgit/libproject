package com.libproject.controller;

import com.libproject.model.Book;
import com.libproject.model.Employee;
import com.libproject.service.BookService;
import com.libproject.service.EmployeeService;
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
    private EmployeeService employeeService;

    @Autowired
    public LibController(BookService bookService, EmployeeService employeeService) {
        this.bookService = bookService;
        this.employeeService = employeeService;
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

    @GetMapping("employee")
    public List<Employee> getEmployee() {
        return this.employeeService.getAll();
    }

    @PostMapping("employee")
    public Long createEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee.getFirstname(), employee.getLastname());
    }

    @GetMapping("books/{employeeId}")
    public List<Book> getBooksOfEmployee(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.getBooksOfEmployee(employeeId);
    }

    @GetMapping("selectbook/{employeeId}/{bookId}")
    public boolean selectBook(@PathVariable("employeeId") Long employeeId, @PathVariable("bookId") Long bookId) {
        return this.employeeService.changeBookState(employeeId, bookId);
    }

    @GetMapping("book/{id}/employees")
    public List<Employee> getEmployeeReadBook(@PathVariable("id") Long id) {
        return this.employeeService.getEmployeeHowReadBook(id);
    }

}
