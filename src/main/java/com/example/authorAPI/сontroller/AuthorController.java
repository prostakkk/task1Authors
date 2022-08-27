package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.exception.AuthorAlreadyExistException;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return ResponseEntity.badRequest().body("Unable to add Author." + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAuthor(@RequestParam Long id) {
        try { // No value present
            return ResponseEntity.ok(authorService.getAuthor(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAuthors();
    }
    // Get all authors



    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        try {
            return ResponseEntity.ok(authorService.deleteAuthor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity deleteAuthors( AuthorEntity author){
        try {
            authorService.deleteAuthors(author);
            return  ResponseEntity.ok("Authors deleted successfully");
        }
        catch ( AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
            // good
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateAuthor(@RequestBody AuthorEntity author){
        try {
            authorService.updateAuthor(author);
            return  ResponseEntity.ok("Author updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
