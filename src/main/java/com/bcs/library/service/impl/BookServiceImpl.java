package com.bcs.library.service.impl;

import com.bcs.library.dto.BookCategoryDto;
import com.bcs.library.dto.BookDto;
import com.bcs.library.exception.ResourceNotFoundException;
import com.bcs.library.model.BookCategoriesMappingModel;
import com.bcs.library.model.BookCategoryMappingsModel;
import com.bcs.library.model.BookModel;
import com.bcs.library.repository.BookRepository;
import com.bcs.library.repository.JpaBookCategoryMappingsResource;
import com.bcs.library.repository.JpaBookCategoryRepository;
import com.bcs.library.repository.JpaBookRepository;
import com.bcs.library.service.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    JpaBookRepository jpaBookRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    JpaBookCategoryRepository bookCategoryRepository;

    @Autowired
    JpaBookCategoryMappingsResource jpaBookCategoryMappingsResource;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<BookDto> retrieveBooks() {
    List<BookModel> books = (List<BookModel>) jpaBookRepository.findAll();

    if(books.isEmpty()){
        System.out.println("Test");
        throw new RuntimeException();
    }
    return books.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private BookDto convertToDto(BookModel book){
        List<BookCategoriesMappingModel> bookCategoriesMappings = book.getBookCategories();

        if(bookCategoriesMappings.isEmpty()){
            System.out.println("Test");
        }

        BookDto bookDto = modelMapper.map(book, BookDto.class);
        List<BookCategoryDto> categories = new ArrayList<>();
        for (BookCategoriesMappingModel bookCategoriesMapping : bookCategoriesMappings ){
            System.out.println(bookCategoriesMapping.getBookCategory());
            categories.add(modelMapper.map(bookCategoriesMapping.getBookCategory(), BookCategoryDto.class));
        }
        bookDto.setBookCategories(categories);
        return bookDto;
    }

    @Override
    @Transactional
    public void addBook(BookDto book) {
        jpaBookRepository.save(modelMapper.map(book, BookModel.class));
    }

    @Override
    public void addBooks(List<BookDto> books) {
        List<BookModel> bookModels = books.stream().map(book -> {
           return modelMapper.map(book, BookModel.class);
        }).collect(Collectors.toList());
        bookModels.forEach(book -> jpaBookRepository.save(book));
    }

    @Override
    public Optional<BookDto> updateBook(BookDto book) {

        if(jpaBookRepository.existsById(book.getId())){
            throw new ResourceNotFoundException("BookID : " + book.getId() + " not found");
        }

        return jpaBookRepository.findById(book.getId()).map(bookExists -> {
            bookExists = modelMapper.map(book, BookModel.class);
            return modelMapper.map(bookExists, BookDto.class);
        });
    }

    @Override
    public void deleteBook(Long id) {
        if(!jpaBookRepository.existsById(id)){
            throw new ResourceNotFoundException("BookID : " + id + " not found");
        }
        bookRepository.deleteBook(id);
    }

    @Override
    public void deleteBooks(List<Long> bookIds) {

        for(Long id : bookIds){
            if(!jpaBookRepository.existsById(id)){
                throw new ResourceNotFoundException("BookID : " + id + " not found");
            }
            bookRepository.deleteBook(id);
        }
    }

    @Override
    public void assignBookCategory(Long bookId, List<Long> bookCategoryIds) {
        BookCategoryMappingsModel bookCategoryMappingsModel = new BookCategoryMappingsModel();
        if(!jpaBookRepository.existsById(bookId)){
            throw new ResourceNotFoundException("BookID : " + bookId + " not found");
        }
        bookCategoryMappingsModel.setBookId(bookId);
        for (Long id : bookCategoryIds){
            if(!bookCategoryRepository.existsById(id)){
                throw new ResourceNotFoundException("Book Category Id : " + id + " not found");
            }
            bookCategoryMappingsModel.setBookCategoryId(id);
            bookCategoryMappingsModel.setDeleted(false);
            jpaBookCategoryMappingsResource.save(bookCategoryMappingsModel);
        }
    }

    @Override
    public void removeBookCategory(Long bookId, List<Long> bookCategoryIds) {
//        BookCategoryMappingsModel bookCategoryMappingsModel = new BookCategoryMappingsModel();
//        if(!bookRepository.existsById(bookId)){
//            throw new ResourceNotFoundException("BookID : " + bookId + " not found");
//        }
//        bookCategoryMappingsModel.setBookId(bookId);
//        for (Long id : bookCategoryIds){
//            if(!bookCategoryRepository.existsById(id)){
//                throw new ResourceNotFoundException("Book Category Id : " + id + " not found");
//            }
//            bookCategoryMappingsModel.setBookCategoryId(id);
//            bookCategoryMappingsModel.setDeleted(false);
//            jpaBookCategoryMappingsResource.save(bookCategoryMappingsModel);
//        }
    }

}
