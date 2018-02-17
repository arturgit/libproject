package com.libproject.service;

import com.libproject.model.Employee;
import com.libproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 18.02.2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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

}
