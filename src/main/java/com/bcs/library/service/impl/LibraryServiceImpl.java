package com.bcs.library.service.impl;

import com.bcs.library.dto.BookCategoryDto;
import com.bcs.library.dto.BookDto;
import com.bcs.library.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {


    @Override
    public List<BookDto> retrieveBooks() {
        return new ArrayList<BookDto>();
    }

    @Override
    public List<BookCategoryDto> retrieveBookCategories() {
        return null;
    }

    @Override
    public void uploadBookCategory(List<BookCategoryDto> bookCategories) {

    }
}
