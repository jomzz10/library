package com.bcs.library.repository;

import com.bcs.library.model.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<BookModel, Long> {
}
