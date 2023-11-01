package com.booksdata.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "books_data")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_Id")
    int id;

    @Column(name = "book_name")
    String book_name;
    @Column(name = "description")
    String description;
    @Column(name = "author")
    String author;
    @Column(name = "isAvailable")
    boolean isAvailable;

}