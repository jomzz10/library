package com.bcs.library.repository;

import com.bcs.library.dto.BookDto;

public interface BookRepository {

    void updateBook(BookDto book);

}
