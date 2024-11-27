package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "author")
public class Authors {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long author_id;
	    
	    private String name;
	    private String biography;

	    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Books> books;

		public Long getAuthor_id() {
			return author_id;
		}

		public void setAuthor_id(Long author_id) {
			this.author_id = author_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBiography() {
			return biography;
		}

		public void setBiography(String biography) {
			this.biography = biography;
		}

		public List<Books> getBooks() {
			return books;
		}

		public void setBooks(List<Books> books) {
			this.books = books;
		}

}

