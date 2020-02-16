package com.bcs.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity(name="book")
public class BookModel {

    @Id
    private Long id;

    private String title;

    private String author;

    private String description;

    private String copyright;

    @ManyToOne
    private BookCategoryModel bookCategoryModel;

}
