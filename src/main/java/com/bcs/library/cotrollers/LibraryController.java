package com.bcs.library.cotrollers;

import com.bcs.library.service.LibraryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library")
@Api(value="/v1/library",produces ="application/json")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity retrieveBooks(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/save/book")
    public ResponseEntity saveBook(){
        return ResponseEntity.ok("");
    }

    @PutMapping("/book/{id}")
    public ResponseEntity updateBook(){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(){
        return ResponseEntity.ok("");
    }

}
