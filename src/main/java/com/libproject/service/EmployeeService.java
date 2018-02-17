package com.libproject.service;

import com.libproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 18.02.2018.
 */
@Service
public interface EmployeeService {

    public Long saveEmployee(String firstname, String lastname);

    public List<Employee> getAll();

}
