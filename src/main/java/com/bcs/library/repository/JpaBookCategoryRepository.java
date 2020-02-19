package com.bcs.library.repository;

import com.bcs.library.model.BookCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface JpaBookCategoryRepository extends JpaRepository<BookCategoryModel, Long> {

}
