package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.exception.AuthorAlreadyExistException;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.exception.NoAuthorsException;
import com.example.authorAPI.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/set")
    public ResponseEntity addAuthor(@RequestBody AuthorEntity author){
        try {
           authorService.addAuthor(author);
            return  ResponseEntity.ok("Author saved successfully");
        } catch (AuthorAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAuthor(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(authorService.getAuthor(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        try {
            return ResponseEntity.ok(authorService.deleteAuthor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity deleteAuthor( AuthorEntity author){
        try {
            authorService.deleteAuthors(author);
            return  ResponseEntity.ok("Authors deleted successfully");
        }
        catch ( NoAuthorsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
