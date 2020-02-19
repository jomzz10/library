package com.bcs.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book_category_mapping")
public class BookCategoryMappingsModel extends DateModel{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_category_id")
    private Long bookCategoryId;

    private Boolean deleted;
}
