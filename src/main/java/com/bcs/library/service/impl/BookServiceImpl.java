package com.bcs.library.service.impl;

import com.bcs.library.dto.BookDto;
import com.bcs.library.exception.ResourceNotFoundException;
import com.bcs.library.model.BookModel;
import com.bcs.library.repository.BookRepository;
import com.bcs.library.service.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    ModelMapper modelMapper;

    @Override
    public List<BookDto> retrieveBooks() {
    List<BookModel> books = (List<BookModel>) bookRepository.findAll();
        return books.stream().map(book -> {
            return modelMapper.map(book, BookDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public void addBook(BookDto book) {
        bookRepository.save(modelMapper.map(book, BookModel.class));
    }

    @Override
    public void addBooks(List<BookDto> books) {
        List<BookModel> bookModels = books.stream().map(book -> {
           return modelMapper.map(book, BookModel.class);
        }).collect(Collectors.toList());
        bookModels.forEach(book -> bookRepository.save(book));
    }

    @Override
    public Optional<BookDto> updateBook(BookDto book) {

        if(bookRepository.existsById(book.getId())){
            throw new ResourceNotFoundException("BookID : " + book.getId() + " not found");
        }

        return bookRepository.findById(book.getId()).map(bookExists -> {
            bookExists = modelMapper.map(book, BookModel.class);
            return modelMapper.map(bookExists, BookDto.class);
        });
    }

    @Override
    public void deleteBook(Long id) {


    }

    @Override
    public void deleteBooks(List<Long> bookIds) {

    }

    @Override
    public BookDto assignBookCategory(BookDto book, List<Long> bookCategoryIds) {
        return null;
    }

    @Override
    public BookDto removeBookCategory(BookDto book, List<Long> bookCategoryIds) {
        return null;
    }

}
