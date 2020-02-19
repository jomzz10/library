package com.bcs.library.repository.impl;

import com.bcs.library.dto.BookDto;
import com.bcs.library.model.BookModel;
import com.bcs.library.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void updateBook(BookDto book) {

    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        BookModel book = em.find(BookModel.class, bookId);
        book.setDeleted(true);

        em.merge(book);
        em.flush();
    }
}
