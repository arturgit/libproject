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
@Table(name = "employee")
public class Employee {

    public Employee() {}

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

}
