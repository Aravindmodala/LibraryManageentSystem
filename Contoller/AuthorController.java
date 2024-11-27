package com.example.demo.Contoller;

import com.example.demo.Entity.Authors;
import com.example.demo.Service.Authorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private Authorservice authorService;

    // Create a new author
    @PostMapping
    public ResponseEntity<Authors> addAuthor(@RequestBody Authors author) {
        Authors savedAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    // Get all authors
    @GetMapping
    public ResponseEntity<List<Authors>> getAllAuthors() {
        List<Authors> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    // Get an author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
        Optional<Authors> author = authorService.getAuthorById(id);
        return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an author
    @PutMapping("/{id}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable Long id, @RequestBody Authors updatedAuthor) {
        Authors author = authorService.updateAuthor(id, updatedAuthor);
        return author != null ? new ResponseEntity<>(author, HttpStatus.OK)
                              : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete an author
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Long id) {
        boolean isDeleted = authorService.deleteAuthor(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
