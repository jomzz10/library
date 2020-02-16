package com.bcs.library.service;

import com.bcs.library.dto.BookCategoryDto;
import com.bcs.library.dto.BookDto;

import java.util.List;

public interface LibraryService {

    List<BookDto> retrieveBooks();

    List<BookCategoryDto> retrieveBookCategories();

    void uploadBookCategory(List<BookCategoryDto> bookCategories);

}
