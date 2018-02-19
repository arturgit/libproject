package com.libproject.repository;

import com.libproject.model.EmployeeBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Artur on 18.02.2018.
 */
public interface EmployeeBookRepository extends JpaRepository<EmployeeBook, Long> {

    List<EmployeeBook> findAllByEmployeeId(Long id);

    List<EmployeeBook> findAllByBookId(Long id);

    EmployeeBook findFirstByEmployeeIdAndBookId(Long employeeId, Long bookId);

}
