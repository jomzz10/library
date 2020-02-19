package com.bcs.library.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library/books/category")
@Api(value="v1/library/books/category",produces ="application/json")
public class BookCategoryController {

    @GetMapping("/")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity retrieveBookCategories(){
       return ResponseEntity.ok("");
    }

    @PostMapping("/upload")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity uploadBookCategories(){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Returns list of all Book Categories in the system.")
    public ResponseEntity deleteBookCategories(){
        return ResponseEntity.ok("");
    }
}
