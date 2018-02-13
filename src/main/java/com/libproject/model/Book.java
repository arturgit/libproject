package com.libproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Artur on 12.02.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    public Book() {}

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

}
