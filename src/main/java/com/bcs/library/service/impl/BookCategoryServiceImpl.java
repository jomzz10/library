package com.bcs.library.service.impl;

import com.bcs.library.dto.BookCategoryDto;
import com.bcs.library.service.IBookCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements IBookCategoryService {
    @Override
    public List<BookCategoryDto> retrieveBookCategories() {
        return null;
    }

    @Override
    public void uploadBookCategory(List<BookCategoryDto> bookCategories) {

    }
}
