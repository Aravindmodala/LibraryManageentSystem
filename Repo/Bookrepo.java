package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Books;
@Repository
public interface Bookrepo extends JpaRepository<Books, Long> {
	    List<Books> findByGenre(String genre); // Filter by genre
	    List<Books> findByAuthor_Name(String authorName); // Filter by author
	}


