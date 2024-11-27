package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Genre;
import com.example.demo.Repo.Genrerepo;

@Service
public class Genreservice {
	 @Autowired
	    private Genrerepo genreRepository;
	 
	    public Genre saveGenre(Genre genre) {
	        return genreRepository.save(genre);
	    }


	    // Create a new genre
	    public Genre createGenre(Genre genre) {
	        return genreRepository.save(genre);
	    }

	    // Get all genres
	    public List<Genre> getAllGenres() {
	        return genreRepository.findAll();
	    }

	    // Get a genre by ID
	    public Genre getGenreById(Long id) {
	        return genreRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Genre not found with ID: " + id));
	    }

	    // Update a genre
	    public Genre updateGenre(Long id, Genre genreDetails) {
	        Genre genre = getGenreById(id);
	        genre.setName(genreDetails.getName());
	        return genreRepository.save(genre);
	    }

	    // Delete a genre
	    public void deleteGenre(Long id) {
	        genreRepository.deleteById(id);
	    }
	}


