package com.bcs.library.controllers;

import com.bcs.library.dto.BookDto;
import com.bcs.library.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/library/book")
@Api(value="v1/library/book",produces ="application/json")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity retrieveBooks(){
        return new ResponseEntity<List<BookDto>>(bookService.retrieveBooks(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity addBook(@RequestBody BookDto book){
        bookService.addBook(book);
        return ResponseEntity.ok("");
    }

    @PostMapping("/batch/add")
    public ResponseEntity addBooks(@RequestBody List<BookDto> books){
        bookService.addBooks(books);
        return ResponseEntity.ok("");
    }

    @PutMapping("/update")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity updateBook(@RequestBody BookDto book){

        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/batch/delete/{ids}")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity batchDeleteBook(@PathVariable List<Long> ids){
        bookService.deleteBooks(ids);
        return ResponseEntity.ok("");
    }

    @PostMapping("/{id}/assign/categories/{ids}")
    public ResponseEntity assignBookCategories(@PathVariable("id") Long bookId,@PathVariable("ids") List<Long> categoriesIds){
        bookService.assignBookCategory(bookId, categoriesIds);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/remove/categories/{ids}")
    public ResponseEntity removeBookCategories(@PathVariable("id") Long bookId,@PathVariable("ids") List<Long> categoriesIds){
        bookService.removeBookCategory(bookId, categoriesIds);
        return ResponseEntity.ok("");
    }

}
