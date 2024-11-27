package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long genre_id;
	    
	    private String name;

	    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Books> books;

		public Long getGenre_id() {
			return genre_id;
		}

		public void setGenre_id(Long genre_id) {
			this.genre_id = genre_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Books> getBooks() {
			return books;
		}

		public void setBooks(List<Books> books) {
			this.books = books;
		}


}
