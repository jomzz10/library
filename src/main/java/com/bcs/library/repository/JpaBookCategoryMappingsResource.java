package com.bcs.library.repository;

import com.bcs.library.model.BookCategoryMappingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JpaBookCategoryMappingsResource extends JpaRepository<BookCategoryMappingsModel, Long> {
}
