package com.bcs.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book_category_mapping")
public class BookCategoriesMappingModel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    @OneToOne
    @JoinColumn(name = "book_category_id")
    private BookCategoryModel bookCategory;


}
