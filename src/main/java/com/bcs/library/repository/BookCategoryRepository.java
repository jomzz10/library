package com.bcs.library.repository;

import com.bcs.library.model.BookCategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookCategoryRepository extends CrudRepository<BookCategoryModel, Long> {

}
