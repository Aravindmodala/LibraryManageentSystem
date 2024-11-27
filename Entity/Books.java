package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "book")

public class Books {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long book_id;
	    
	    private String title;
	    private String description;
	    private int available_copies;
	    private double price;
	    private String isbn;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private Users user; // Relationship with User (user who added the book)

	    @ManyToMany
	    @JoinTable(
	        name = "author_books", // Join table for authors and books
	        joinColumns = @JoinColumn(name = "book_id"),
	        inverseJoinColumns = @JoinColumn(name = "author_id")
	    )
	    private List<Authors> authors; // Relationship with Author

	    public Long getBook_id() {
			return book_id;
		}

		public void setBook_id(Long book_id) {
			this.book_id = book_id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getAvailable_copies() {
			return available_copies;
		}

		public void setAvailable_copies(int available_copies) {
			this.available_copies = available_copies;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		 public List<Authors> getAuthors() {
		        return authors;
		}

		  public void setAuthors(List<Authors> authors) {
		        this.authors = authors;
		}

		public Genre getGenre() {
			return genre;
		}

		public void setGenre(Genre genre) {
			this.genre = genre;
		}

		public Mood getMood() {
			return mood;
		}

		public void setMood(Mood mood) {
			this.mood = mood;
		}

		public LocalDate getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(LocalDate releaseDate) {
			this.releaseDate = releaseDate;
		}

		@ManyToOne
	    @JoinColumn(name = "genre_id", nullable = false)
	    private Genre genre; // Relationship with Genre

	    @ManyToOne
	    @JoinColumn(name = "mood_id", nullable = false)
	    private Mood mood; // Relationship with Mood

	    private LocalDate releaseDate;

}
