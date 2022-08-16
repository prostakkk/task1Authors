package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.entity.BooksEntity;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;


    @GetMapping("/getAll")
    public List<BooksEntity> getBooks(){
        return booksService.getBooks();
    }




    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BooksEntity booksEntity,
                                     @RequestParam Long authorId){
        try {
            return ResponseEntity.ok(booksService.addBook(booksEntity, authorId));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");

        }

    }
    @PutMapping("/upd")

    public ResponseEntity updateBook(@RequestBody BooksEntity books){
        try {
            booksService.updateBook(books);
            return  ResponseEntity.ok("Book updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }

}
