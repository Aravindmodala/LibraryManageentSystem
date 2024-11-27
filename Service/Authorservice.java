package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Authors;
import com.example.demo.Repo.Authorrepo.AuthorRepository;

@Service
public class Authorservice {
	@Autowired
    private AuthorRepository authorRepository;

    // Add a new author
    public Authors addAuthor(Authors author) {
        return authorRepository.save(author);
    }

    // Get all authors
    public List<Authors> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get an author by ID
    public Optional<Authors> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    // Update an author
    public Authors updateAuthor(Long id, Authors updatedAuthor) {
        if (authorRepository.existsById(id)) {
            updatedAuthor.setAuthor_id(id);
            return authorRepository.save(updatedAuthor);
        }
        return null;
    }

    // Delete an author
    public boolean deleteAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


