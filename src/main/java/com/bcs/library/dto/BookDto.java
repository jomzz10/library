package com.bcs.library.dto;

import com.bcs.library.model.BookCategoryModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String description;

    private String copyright;

    private BookCategoryModel bookCategoryModel;
}
