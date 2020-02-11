package com.bcs.library.model;

import lombok.Data;

@Data
public class BookModel {

    private Long id;

    private String title;

    private String author;

    private String description;

    private String copyright;

    private BookCategoryModel bookCategoryModel;

}
