package com.bcs.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String description;

    private String copyright;

    private Boolean deleted;

    private List<BookCategoryDto> bookCategories;
}
