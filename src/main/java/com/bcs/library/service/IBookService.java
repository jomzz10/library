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

    void assignBookCategory(Long bookId, List<Long> bookCategoryIds);

    void removeBookCategory(Long bookId, List<Long> bookCategoryIds);

}
