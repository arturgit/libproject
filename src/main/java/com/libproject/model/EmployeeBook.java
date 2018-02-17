package com.libproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Artur on 18.02.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "employee_book")
public class EmployeeBook {

    public EmployeeBook() {}

    public EmployeeBook(Employee employee, Book book) {
        this.employee = employee;
        this.book = book;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
