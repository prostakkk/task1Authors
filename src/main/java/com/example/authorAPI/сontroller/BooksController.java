package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.entity.BooksEntity;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.model.Author;
import com.example.authorAPI.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Books")
@RequestMapping("/books")

public class BooksController {
    @Autowired
    private BooksService booksService;


    @GetMapping("/getAll")
    @Operation(summary = "Get all books")
    public List<BooksEntity> getBooks(){
        return booksService.getBooks();
    }




    @PostMapping("/add")
    @Operation(summary = "Add a book")
    public ResponseEntity addBook(@RequestBody BooksEntity booksEntity,
                                     @RequestParam Long authorId){
        try {
            return ResponseEntity.ok(booksService.addBook(booksEntity, authorId));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to add a book.");

        }

    }
    @PutMapping("/upd")
    @Operation(summary = "Update a book")

    public ResponseEntity updateBook(@RequestBody BooksEntity books){
        try {
            booksService.updateBook(books);
            return  ResponseEntity.ok("Book updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }

}
