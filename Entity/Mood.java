package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "mood")
public class Mood {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long mood_id;
	  
	    private String name;
	    
	    private String description;

	    @ManyToMany(mappedBy = "mood", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Books> books;

		public Long getMood_id() {
			return mood_id;
		}

		public void setMood_id(Long mood_id) {
			this.mood_id = mood_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Books> getBooks() {
			return books;
		}

		public void setBooks(List<Books> books) {
			this.books = books;
		}
}
