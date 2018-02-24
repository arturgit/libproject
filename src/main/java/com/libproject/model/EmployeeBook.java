package com.libproject.model;

import javax.persistence.*;

/**
 * Created by Artur on 18.02.2018.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
