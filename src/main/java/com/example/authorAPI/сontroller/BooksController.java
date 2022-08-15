package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.BooksEntity;
import com.example.authorAPI.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody BooksEntity booksEntity,
                                     @RequestParam Long authorId){
        try {
            return ResponseEntity.ok(booksService.addBook(booksEntity, authorId));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");

        }

    }
    @PutMapping
    public ResponseEntity updateBook(@RequestParam Long id){
        try {
            return ResponseEntity.ok(booksService.updateBook(id));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
