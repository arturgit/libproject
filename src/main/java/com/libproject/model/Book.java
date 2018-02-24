package com.libproject.model;

import javax.persistence.*;

/**
 * Created by Artur on 12.02.2018.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "author")
    private String author;

}
