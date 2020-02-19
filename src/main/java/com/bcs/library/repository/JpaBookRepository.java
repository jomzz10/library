package com.bcs.library.repository;

import com.bcs.library.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JpaBookRepository extends JpaRepository<BookModel, Long> {
}
