package com.libproject.service;

import com.libproject.model.Book;
import com.libproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 18.02.2018.
 */
@Service
public interface EmployeeService {

    Long saveEmployee(String firstname, String lastname);

    List<Employee> getAll();

    List<Book> getBooksOfEmployee(Long id);

    boolean changeBookState(Long employeeId, Long bookId);

    List<Employee> getEmployeeHowReadBook(Long id);
}
