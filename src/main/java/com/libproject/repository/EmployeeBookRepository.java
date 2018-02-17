package com.libproject.repository;

import com.libproject.model.EmployeeBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 18.02.2018.
 */
public interface EmployeeBookRepository extends JpaRepository<EmployeeBook, Long> {

}
