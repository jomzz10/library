package com.bcs.library.service;

import com.bcs.library.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<BookDto> retrieveBooks();

    void addBook(BookDto book);

    void addBooks(List<BookDto> books);

    Optional<BookDto> updateBook(BookDto book);

    void deleteBook(Long id);

    void deleteBooks(List<Long> bookIds);

    BookDto assignBookCategory(BookDto book, List<Long> bookCategoryIds);

    BookDto removeBookCategory(BookDto book, List<Long> bookCategoryIds);

}
