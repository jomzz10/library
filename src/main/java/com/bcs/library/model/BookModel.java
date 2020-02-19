package com.bcs.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "book")
public class BookModel extends DateModel {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private String description;

    private String copyright;

    private Boolean deleted;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
//    @JsonIgnore
    private List<BookCategoriesMappingModel> bookCategories;

}
