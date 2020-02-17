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
@RequestMapping(value = "/v1/library/books")
@Api(value="/v1/library",produces ="application/json")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity retrieveBooks(){
        return new ResponseEntity<List<BookDto>>(bookService.retrieveBooks(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity addBook(){
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity updateBook(){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity deleteBook(){
        return ResponseEntity.ok("");
    }

}
