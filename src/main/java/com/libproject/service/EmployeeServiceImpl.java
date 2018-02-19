package com.libproject.service;

import com.libproject.model.Book;
import com.libproject.model.Employee;
import com.libproject.model.EmployeeBook;
import com.libproject.repository.BookRepository;
import com.libproject.repository.EmployeeBookRepository;
import com.libproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artur on 18.02.2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeBookRepository employeeBookRepository;
    private BookRepository bookRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeBookRepository employeeBookRepository, BookRepository bookRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeBookRepository = employeeBookRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Long saveEmployee(String firstname, String lastname) {
        Employee employee = this.employeeRepository.save(new Employee(firstname, lastname));
        return employee.getId();
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public List<Book> getBooksOfEmployee(Long id) {
        List<EmployeeBook> employeeBooks = this.employeeBookRepository.findAllByEmployeeId(id);
        List<Book> books = new LinkedList<>();
        for(EmployeeBook eb: employeeBooks) {
            books.add(eb.getBook());
        }
        return books;
    }

    @Override
    public boolean changeBookState(Long employeeId, Long bookId) {
        EmployeeBook eb = this.employeeBookRepository.findFirstByEmployeeIdAndBookId(employeeId, bookId);
        if (eb == null) {
            this.employeeBookRepository.save(new EmployeeBook(this.employeeRepository.findOne(employeeId), this.bookRepository.findOne(bookId)));
            return true;
        } else {
            this.employeeBookRepository.delete(eb.getId());
            return false;
        }
    }

    @Override
    public List<Employee> getEmployeeHowReadBook(Long id) {
        List<EmployeeBook> employeeBooks = this.employeeBookRepository.findAllByBookId(id);
        List<Employee> employees = new LinkedList<>();
        for(EmployeeBook eb: employeeBooks) {
            employees.add(eb.getEmployee());
        }
        return employees;
    }

}
