package com.libproject.repository;

import com.libproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Artur on 18.02.2018.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
