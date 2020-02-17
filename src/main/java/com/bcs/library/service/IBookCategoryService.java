package com.bcs.library.service;

import com.bcs.library.dto.BookCategoryDto;

import java.util.List;

public interface IBookCategoryService {

    List<BookCategoryDto> retrieveBookCategories();

    void uploadBookCategory(List<BookCategoryDto> bookCategories);
}
