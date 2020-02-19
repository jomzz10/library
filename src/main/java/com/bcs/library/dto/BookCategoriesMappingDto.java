package com.bcs.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookCategoriesMappingDto {
    List<BookCategoryDto> categories;
}
