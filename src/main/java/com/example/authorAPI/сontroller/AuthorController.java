package com.example.authorAPI.сontroller;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.exception.AuthorAlreadyExistException;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.model.Author;
import com.example.authorAPI.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Author")
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @PostMapping("/set")
    @Operation(summary = "Set author", responses = {
            @ApiResponse(
                    description = "Author saved successfully",
                    responseCode = "200",
                    content = @Content)
    })

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
    @Operation(summary = "Get one author", responses = {
            @ApiResponse(
                    description = "Get author success",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Author.class)
                    )
            ),
            @ApiResponse(
                    description = "Author not found",
                    responseCode = "400",
                    content = @Content
            )
    })
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
    @Operation(summary = "Get all authors")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAuthors();
    }
    // Get all authors



    @DeleteMapping("/delete{id}")
    @Operation(summary = "Delete author by id")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        try {
            return ResponseEntity.ok(authorService.deleteAuthor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/deleteall")
    @Operation(summary = "Delete all authors", responses = {
            @ApiResponse(
                    description = "Authors deleted successfully",
                    responseCode = "200",
                    content = @Content)
    })

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
    @Operation(summary = "Update author", responses = {
            @ApiResponse(
                    description = "Author updated successfully",
                    responseCode = "200",
                    content = @Content)
    })
    public ResponseEntity updateAuthor(@RequestBody AuthorEntity author){
        try {
            authorService.updateAuthor(author);
            return  ResponseEntity.ok("Author updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
